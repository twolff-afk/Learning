
#include <xercesc/parsers/XercesDOMParser.hpp>
#include <xercesc/dom/DOM.hpp>
#include <xercesc/sax/HandlerBase.hpp>
#include <xercesc/util/XMLString.hpp>
#include <xercesc/util/PlatformUtils.hpp>

#include <iostream>
#include <codecvt>
#include <string>

using namespace std;
using namespace xercesc;

/*

Xerces aehnelt sehr dem DOM aus JAVA.

gutes Tutorial: http://www.yolinux.com/TUTORIALS/XML-Xerces-C.html

*/


int main()
{

    try
    {
        XMLPlatformUtils::Initialize();
    }
    catch (const XMLException& toCatch) 
    {

        char* message = XMLString::transcode(toCatch.getMessage());
        cout << "Error during initialization! :\n" << message << "\n";
        XMLString::release(&message);
        return 1;

    }

    XercesDOMParser* parser = new XercesDOMParser();
    parser->setValidationScheme(XercesDOMParser::Val_Always);
    parser->setDoNamespaces(true);    // optional

    ErrorHandler* errHandler = (ErrorHandler*) new HandlerBase();
    parser->setErrorHandler(errHandler);

    char xmlFile[] = "../testService.wsdl";

    try
    {

        parser->parse(xmlFile);

        xercesc_3_2::DOMDocument* xmlDoc = parser->getDocument();

        // Get the top-level element: Name is "root". No attributes for "root"
        DOMElement* elementRoot = xmlDoc->getDocumentElement();

        DOMNodeList* children = elementRoot->getChildNodes();

        XMLSize_t nodeCount = children->getLength();

        for (XMLSize_t xx = 0; xx < nodeCount; ++xx)
        {

            DOMNode* currentNode = children->item(xx);

            if (currentNode->getNodeType() && currentNode->getNodeType() == DOMNode::ELEMENT_NODE) // true is not NULL && is element
            {
                // Found node which is an Element. Re-cast node as element
                DOMElement* currentElement = dynamic_cast<xercesc::DOMElement*>(currentNode);

                // WICHTIGE Funktion !!!!!
                // XMLString::transcode("message") konvertiert "message" in den notwendigen Datentyp
                if (XMLString::equals(currentElement->getTagName(), XMLString::transcode("message")))
                {
                    // Already tested node as type element and of name "message".

                    // Read attributes of element "name".
                    const XMLCh* xmlch_OptionA = currentElement->getAttribute(XMLString::transcode("name"));

                    cout << XMLString::transcode(xmlch_OptionA) << endl;
                }
            }
        }

    }

    catch (const XMLException& toCatch)
    {
        char* message = XMLString::transcode(toCatch.getMessage());
        cout << "Exception message is: \n" << message << "\n";
        XMLString::release(&message);
        return -1;
    }

    catch (const DOMException& toCatch)
    {
        char* message = XMLString::transcode(toCatch.msg);
        cout << "Exception message is: \n" << message << "\n";
        XMLString::release(&message);
        return -1;
    }

    catch (...)
    {
        cout << "Unexpected Exception \n";
        return -1;
    }

    delete parser;
    delete errHandler;

}



#include <open62541/server.h>
#include <open62541/server_config_default.h>

#include <open62541/plugin/log_stdout.h>

#include <open62541/client.h>
#include <open62541/client_config_default.h>

#include <signal.h>
#include <stdlib.h>

UA_Boolean running = true;


static UA_StatusCode helloWorldMethodCallback (UA_Server* server,
    const UA_NodeId* sessionId, void* sessionHandle,
    const UA_NodeId* methodId, void* methodContext,
    const UA_NodeId* objectId, void* objectContext,
    size_t inputSize, const UA_Variant* input,
    size_t outputSize, UA_Variant* output) {


    UA_String* inputStr = (UA_String*)input->data;
    UA_String tmp = UA_STRING_ALLOC("Hello ");

    if (inputStr->length > 0)
    {
        tmp.data = (UA_Byte*)UA_realloc(tmp.data, tmp.length + inputStr->length);
        memcpy(&tmp.data[tmp.length], inputStr->data, inputStr->length);
        tmp.length += inputStr->length;
    }
    
    UA_Variant_setScalarCopy(output, &tmp, &UA_TYPES[UA_TYPES_STRING]);
    UA_String_clear(&tmp);
    UA_LOG_INFO(UA_Log_Stdout, UA_LOGCATEGORY_SERVER, "Hello World was called");
    return UA_STATUSCODE_GOOD;

}


static void updateCurrentTime(UA_Server* server) {

    char currentTime[] = "current-time-value-callback";

    UA_DateTime now = UA_DateTime_now();
    UA_Variant value;
    UA_Variant_setScalar(&value, &now, &UA_TYPES[UA_TYPES_DATETIME]);
    UA_NodeId currentNodeId = UA_NODEID_STRING(1, currentTime);
    UA_Server_writeValue(server, currentNodeId, value);
}



static void beforeReadTime(UA_Server* server,
    const UA_NodeId* sessionId, void* sessionContext,
    const UA_NodeId* nodeid, void* nodeContext,
    const UA_NumericRange* range, const UA_DataValue* data) {

    updateCurrentTime(server);
}

static void afterWriteTime(UA_Server* server,
    const UA_NodeId* sessionId, void* sessionContext,
    const UA_NodeId* nodeId, void* nodeContext,
    const UA_NumericRange* range, const UA_DataValue* data) {

    UA_LOG_INFO(UA_Log_Stdout, UA_LOGCATEGORY_USERLAND, "The variable was updated");
}

static void addValueCallbackToCurrentTimeVariable(UA_Server* server) {

    char currentTime[] = "current-time-value-callback";
    UA_NodeId currentNodeId = UA_NODEID_STRING(1, currentTime);
    UA_ValueCallback callback;
    callback.onRead = beforeReadTime;
    callback.onWrite = afterWriteTime;
    UA_Server_setVariableNode_valueCallback(server, currentNodeId, callback);
}


static void addCurrentTimeVariable(UA_Server* server) {

    char locale[] = "en-US";
    char currentTime[] = "current-time-value-callback";

    UA_DateTime now = 0;
    UA_VariableAttributes attr = UA_VariableAttributes_default;
    attr.displayName = UA_LOCALIZEDTEXT(locale, currentTime);
    attr.accessLevel = UA_ACCESSLEVELMASK_READ | UA_ACCESSLEVELMASK_WRITE;
    UA_Variant_setScalar(&attr.value, &now, &UA_TYPES[UA_TYPES_DATETIME]);

    UA_NodeId currentNodeId = UA_NODEID_STRING(1, currentTime);
    UA_QualifiedName currentName = UA_QUALIFIEDNAME(1, currentTime);
    UA_NodeId parentNodeId = UA_NODEID_NUMERIC(0, UA_NS0ID_OBJECTSFOLDER);
    UA_NodeId parentReferenceNodeId = UA_NODEID_NUMERIC(0, UA_NS0ID_ORGANIZES);
    UA_NodeId variableTypeNodeId = UA_NODEID_NUMERIC(0, UA_NS0ID_BASEDATAVARIABLETYPE);
    UA_Server_addVariableNode(server, currentNodeId, parentNodeId,
        parentReferenceNodeId, currentName,
        variableTypeNodeId, attr, NULL, NULL);

    updateCurrentTime(server);
}

int main()
{

    char locale[] = "en-US";
    char text[] = "theanswer";
    char str[] = "A String";
    char input[] = "MyInput";
    char output[] = "MyOutput";
    char helloWorld[] = "Hello World";

     /* Create a server listening on port 4840 */
    UA_Server* server = UA_Server_new();
    UA_ServerConfig_setDefault(UA_Server_getConfig(server));
    UA_ServerConfig* config = UA_Server_getConfig(server);

    // This changes the port of the application so that different servers can run on the same system
    UA_ServerConfig_setMinimal(config, 9999, NULL);
    UA_String_clear(&config->applicationDescription.applicationUri);
    config->applicationDescription.applicationUri = UA_String_fromChars("urn:open62541.example.server_register");

    addCurrentTimeVariable(server);
    addValueCallbackToCurrentTimeVariable(server);


    
    /* Add a variable node */
    /* 1) Define the node attributes */
    UA_VariableAttributes attr = UA_VariableAttributes_default;
    attr.displayName = UA_LOCALIZEDTEXT(locale, text);
    attr.accessLevel = UA_ACCESSLEVELMASK_READ | UA_ACCESSLEVELMASK_WRITE;
    attr.dataType = UA_TYPES[UA_TYPES_BOOLEAN].typeId;
    
    UA_Boolean value;
    UA_Boolean_init(&value);
    value = false;

    UA_Variant_setScalar(&attr.value, &value, &UA_TYPES[UA_TYPES_BOOLEAN]);

    /* 2) Define where the node shall be added with which browsename */
    UA_NodeId newNodeId = UA_NODEID_STRING(1, text);
    UA_NodeId parentNodeId = UA_NODEID_NUMERIC(0, UA_NS0ID_OBJECTSFOLDER);
    UA_NodeId parentReferenceNodeId = UA_NODEID_NUMERIC(0, UA_NS0ID_ORGANIZES);
    UA_NodeId variableType = UA_NODEID_NULL; /* take the default variable type */
    UA_QualifiedName browseName = UA_QUALIFIEDNAME(1, text);

    /* 3) Add the node */
    UA_Server_addVariableNode
    (
        server, newNodeId,
        parentNodeId, parentReferenceNodeId,
        browseName, variableType,
        attr, NULL, NULL
    );




    char xmlName[] = "xmlElement";

    UA_VariableAttributes xmlAttr = UA_VariableAttributes_default;
    xmlAttr.displayName = UA_LOCALIZEDTEXT(locale, xmlName);
    xmlAttr.accessLevel = UA_ACCESSLEVELMASK_READ | UA_ACCESSLEVELMASK_WRITE;
    xmlAttr.dataType = UA_TYPES[UA_TYPES_XMLELEMENT].typeId;

    UA_XmlElement xml;
    UA_XmlElement_init(&xml);
    
    UA_Variant_setScalar(&xmlAttr.value, &xml, &UA_TYPES[UA_TYPES_XMLELEMENT]);

    UA_NodeId xmlNodeId = UA_NODEID_STRING(1, xmlName);
    UA_NodeId xmlParentNodeId = UA_NODEID_NUMERIC(0, UA_NS0ID_OBJECTSFOLDER);
    UA_NodeId xmlParentReferenceNodeId = UA_NODEID_NUMERIC(0, UA_NS0ID_ORGANIZES);
    UA_NodeId xmlVariableType = UA_NODEID_NULL; /* take the default variable type */
    UA_QualifiedName xmlBrowseName = UA_QUALIFIEDNAME(1, xmlName);

    UA_Server_addVariableNode
    (
        server, xmlNodeId,
        xmlParentNodeId, xmlParentReferenceNodeId,
        xmlBrowseName, xmlVariableType,
        xmlAttr, NULL, NULL
    );

    


    UA_Argument inputArgument;
    UA_Argument_init(&inputArgument);
    inputArgument.description = UA_LOCALIZEDTEXT(locale, str);
    inputArgument.name = UA_STRING(input);
    inputArgument.dataType = UA_TYPES[UA_TYPES_STRING].typeId;
    inputArgument.valueRank = UA_VALUERANK_SCALAR;

    UA_Argument outputArgument;
    UA_Argument_init(&outputArgument);
    outputArgument.description = UA_LOCALIZEDTEXT(locale, str);
    outputArgument.name = UA_STRING(output);
    outputArgument.dataType = UA_TYPES[UA_TYPES_STRING].typeId;
    outputArgument.valueRank = UA_VALUERANK_SCALAR;

    UA_MethodAttributes helloAttr = UA_MethodAttributes_default;
    helloAttr.description = UA_LOCALIZEDTEXT(locale, helloWorld);
    helloAttr.displayName = UA_LOCALIZEDTEXT(locale, helloWorld);
    helloAttr.executable = true;
    helloAttr.userExecutable = true;

    UA_Server_addMethodNode(server, UA_NODEID_NUMERIC(1, 62541),
        UA_NODEID_NUMERIC(0, UA_NS0ID_OBJECTSFOLDER),
        UA_NODEID_NUMERIC(0, UA_NS0ID_HASCOMPONENT),
        UA_QUALIFIEDNAME(1, helloWorld),
        helloAttr, &helloWorldMethodCallback,
        1, &inputArgument, 1, &outputArgument, NULL, NULL);









    UA_Client* clientRegister = UA_Client_new();
    UA_ClientConfig_setDefault(UA_Client_getConfig(clientRegister));

    // periodic server register after 10 Minutes, delay first register for 500ms
    UA_UInt64 callbackId;
    UA_StatusCode retval = UA_Server_addPeriodicServerRegisterCallback(server, clientRegister, DISCOVERY_SERVER_ENDPOINT, 10 * 60 * 1000, 500, &callbackId);

    /*
    if (retval != UA_STATUSCODE_GOOD)
    {
        UA_LOG_ERROR
        (
            UA_Log_Stdout,
            UA_LOGCATEGORY_SERVER,
            "Could not create periodic job for server register. StatusCode %s",
            UA_StatusCode_name(retval)
        );

        UA_Client_disconnect(clientRegister);
        UA_Client_delete(clientRegister);
        UA_Server_delete(server);
        return EXIT_FAILURE;
    }
    */

    /* Run the server loop */
    UA_StatusCode status = UA_Server_run(server, &running);

    UA_Server_delete(server);
    return status;

}
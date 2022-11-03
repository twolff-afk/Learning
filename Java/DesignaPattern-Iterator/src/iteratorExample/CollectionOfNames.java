package iteratorExample;

public class CollectionOfNames implements Container {

    public String names[] = {"Gunther", "Sabrina", "Johannes", "Martin"};

    @Override
    public Iterator getIterator() {
        return new CollectionOfNamesIterate();
    }

    private class CollectionOfNamesIterate implements Iterator {

        int namesIndex;
        @Override
        public boolean hasNext() {

            boolean result = false;
            if (namesIndex < names.length) {
                result = true;
            }

            return result;
        }

        @Override
        public Object next() {

            Object name = null;

            if(this.hasNext()) {

                // Interessant: Hier wird erst namesIndex inkrementiert und anschließend auf den Array zugegriffen
                // namesIndex++;
                name = names[namesIndex++]; // wohin gegen hier, erst auf den array zugegriffen wird und dann die variable inkrementiert
            }

            return name;
        }
    }
}

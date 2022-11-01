package financial;

import main.FinancialDataGateway;
import main.FinancialEntityInterface;

import javax.xml.crypto.Data;

public class FinancialDataMapper implements FinancialDataGateway {

    public FinancialDataMapper() {

    }

    @Override
    public FinancialEntityInterface[] getFinancialEntities() {

        Database database = new Database();

        String tobiEntity = database.getTobiEntityAsString();
        String lenaEntity = database.getLenaEntityAsString();
        String nagelEntity = database.getNagelEntityAsString();
        String[] tobi = tobiEntity.split(",");
        String[] lena = lenaEntity.split(",");
        String[] nagel = nagelEntity.split(",");

        FinancialEntity[] entities;

        entities = new FinancialEntity[]{
                new FinancialEntity(1, 10.1, "tobi"),
                new FinancialEntity(1, 10.1, "tobi"),
                new FinancialEntity(1, 10.1, "tobi")
        };

        return entities;
    }
}

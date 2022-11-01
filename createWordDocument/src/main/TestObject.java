package main;

public class TestObject {

	private String objectText;
	private boolean created;
	
    public TestObject() {
    	this.objectText = "";
    	this.created = true;
    	
    }

	public String getObjectText() {
		return objectText;
	}

	public void setObjectText(String objectText) {
		this.objectText = objectText;
	}

	public boolean isCreated() {
		return created;
	}

	public void setCreated(boolean created) {
		this.created = created;
	}    
    
}

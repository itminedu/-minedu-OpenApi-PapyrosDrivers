package gr.mineedu.papyros.protocol.model;

public enum OpenPapyrosServices {
	PAuth("/authenticate/pauth");


	
    private final String value;

    OpenPapyrosServices(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

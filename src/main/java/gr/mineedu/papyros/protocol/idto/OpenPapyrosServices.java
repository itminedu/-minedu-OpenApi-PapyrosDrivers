package gr.mineedu.papyros.protocol.idto;

public enum OpenPapyrosServices {
	PAuth("/pauthenticate/pauth"),
	EAuth("/eauthenticate/eauth")
	,SearchDocument("search/documents")
	,GetDocumentPdf("document/pdf")
	,GetDocumentData("document/data")
	;


	
    private final String value;

    OpenPapyrosServices(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

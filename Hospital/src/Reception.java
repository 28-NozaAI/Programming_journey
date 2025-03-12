public class Reception {
    private Long ID;
    private Patient patient;
    private String ill;
    private Boolean end;
    private String diagnostic;


    public Reception() {
        this.ID = System.currentTimeMillis();
        this.end = false;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getIll() {
        return ill;
    }

    public void setIll(String ill) {
        this.ill = ill;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public Long getID() {
        return ID;
    }

    public Boolean getEnd() {
        return end;
    }

}

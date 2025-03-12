public class Hospital {
    private Patient[] patients;
    private Reception[] receptions;

    public Hospital(Integer patientCapacity, Integer receptionCapacity) {
        this.patients = new Patient[patientCapacity];
        this.receptions = new Reception[receptionCapacity];
    }


    public void createPatient(String fullName, String passport, Integer age) {
        Patient patient = new Patient();

        patient.setFullName(fullName);
        patient.setPassport(passport);
        patient.setAge(age);

        for (int i = 0; i < patients.length; i++) {
            if (patients[i] == null) {
                patients[i] = patient;
                return;
            }
        }
    }

    public Patient[] getPatients() {
        return patients;
    }

    public Reception[] getReceptions() {
        return receptions;
    }

    public Patient getPatient(long id) {
        for (Patient patient : patients) {
            if (patient != null && patient.getID() == id) {
                return patient;
            }
        }
        return null;
    }


    public void updatePatient(long id, String fullName, String passport, Integer age) {
        Patient patient = getPatient(id);
        patient.setAge(age);
        patient.setFullName(fullName);
        patient.setPassport(passport);
    }

    public void deletePatient(long id) {
        for (int i = 0; i < patients.length; i++) {
            if (patients[i] != null && patients[i].getID() == id) {
                patients[i] = null;
                return;
            }
        }
    }

    public void updateReception(long recID, String diagnostic) {

        Reception reception = getReception(recID);

        if (reception != null) {
            reception.setDiagnostic(diagnostic);
            reception.setEnd(true);
        }

    }

    private Reception getReception(long recId) {

        for (Reception reception : this.receptions) {
            if (reception.getID() == recId) {
                return reception;
            }
        }
        return null;
    }

    public void createReception(long patientId, String ill) {
        // end false, diagnostic null bo'ladi. Chunki u davolash funksiyasida kiritiladi
        Patient patient = getPatient(patientId);
        Reception reception = new Reception();
        reception.setPatient(patient);
        reception.setIll(ill);
        reception.setEnd(false);

        for (int i = 0; i < receptions.length; i++) {
            if (receptions[i] == null) {
                receptions[i] = reception;
                return;
            }
        }
    }

    public boolean anyReceptionExists() {
        for (Reception reception : getReceptions()) {
            if (reception != null && !reception.getEnd()) {
                return true;
            }
        }
        return false;
    }
}

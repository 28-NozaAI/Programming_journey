import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final Scanner SCANNER_STR = new Scanner(System.in);
    private static final Scanner SCANNER_NUM = new Scanner(System.in);
    private static final Hospital HOSPITAL = new Hospital(100, 1000);

    public static void main(String[] args) {
        while (true){
            System.out.println("""
                    -------------Menu-------------
                    1. Yangi bemor qo‘shish
                    2. Bemorni qabulga yozish
                    3. Barcha bemorlarni ko‘rish
                    4. Barcha qabullarni ko‘rish
                    5. Bemorni davolash 
                    6. Tizimdan chiqish
                    """);
            System.out.print(" Tanlash: ");

            int choice = SCANNER_NUM.nextInt();
            SCANNER_NUM.nextLine();
            
            switch (choice){
                case 1 -> {
                    addPatient();
                }
                case 2 -> {
                    addReception();
                }
                case 3 -> {
                    allPatient();
                }
                case 4 -> {
                    allReception(null);
                }
                case 5 -> {
                    treatmentPatient();
                }
                case 6 -> {
                    System.out.println(" Xayr!");
                    return;
                }
                default -> {
                    System.out.println(" Wrong choice!");
                }
            }
        }
    }
    private static void treatmentPatient() {
        allReception(false);
        if (!HOSPITAL.anyReceptionExists()) {
            System.out.println(" Bo'sh");
            return;
        }
        System.out.print(" Reception ID: ");
        long recID = SCANNER_NUM.nextLong();
        System.out.print(" Diagnostic: ");
        SCANNER_STR.nextLine();
        String diagnostic = SCANNER_STR.nextLine();
        HOSPITAL.updateReception(recID, diagnostic);

        System.out.println(" Qabul yakunlandi!!");
    }


    private static void allReception(Boolean end) {
        Reception[] receptions = HOSPITAL.getReceptions();
        for (Reception reception : receptions) {

            if (reception == null || (end != null && reception.getEnd() != end)) {
                continue;
            }

            String status = (reception.getEnd()) ? "✅" : "🕛";
            System.out.printf(" [ ID = %s, patient = %s, ill = %s, diagnostic = %s , %s ] %n", reception.getID(), reception.getPatient().getFullName(), reception.getIll(), reception.getDiagnostic(), status);


        }
    }

    private static void allPatient() {
        Patient[] patients = HOSPITAL.getPatients();
        for (Patient patient : patients) {
            if (patient != null) {
                System.out.printf(" [ ID = %s, full name = %s, age = %s ] %n", patient.getID(), patient.getFullName(), patient.getAge());
            }
        }
    }

    /**
     * Qabul yaratish. Bunda qaysi bemorligi va qaysi kasallik bilan kelganini kirishi yetarli. end aniq false, tashxis aniq null boladi(chunki bu qabul tugatilayotganda  yoziladi)
     */
    private static void addReception() {
        allPatient();
        System.out.print(" Patient id: ");
        long patientId = SCANNER_NUM.nextLong();

        System.out.print(" Ill : ");
        String ill = SCANNER_STR.next();

        HOSPITAL.createReception(patientId, ill);

        System.out.println(" Qabul yaratildi!!");
    }

    private static void addPatient() {
        System.out.print(" Full name: ");
        String fullName = SCANNER_STR.next();
        System.out.print(" Passport: ");
        SCANNER_STR.nextLine();// for scanner bug
        String passport = SCANNER_STR.next();
        System.out.print(" Age: ");
        Integer age = SCANNER_NUM.nextInt();

        HOSPITAL.createPatient(fullName, passport, age);
        System.out.println(" Bemor uchun id karta yaratildi");
    }
}
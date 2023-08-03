package InterfacesAndAbstraction.Exercise.P06MilitaryElite;

import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, Private> privates = new HashMap<>();
        List<LieutenantGeneral> lieutenantGenerals = new ArrayList<>();
        List<Engineer> engineers = new ArrayList<>();
        List<Commando> commandos = new ArrayList<>();
        List<Spy> spies = new ArrayList<>();

        String line = scanner.nextLine();
        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+");
            String type = tokens[0];
            int id = Integer.parseInt(tokens[1]);
            String firstName = tokens[2];
            String lastName = tokens[3];

            switch (type) {
                case "Private":
                    double salary = Double.parseDouble(tokens[4]);
                    Private priv = new PrivateImpl(id, firstName, lastName, salary);
                    privates.put(id, priv);
                    break;
                case "LieutenantGeneral":
                    double lieutenantGeneralSalary = Double.parseDouble(tokens[4]);
                    LieutenantGeneral lieutenantGeneral = new LieutenantGeneralImpl(id, firstName, lastName, lieutenantGeneralSalary);
                    for (int i = 5; i < tokens.length; i++) {
                        int privateId = Integer.parseInt(tokens[i]);
                        if (privates.containsKey(privateId)) {
                            Private privateSoldier = privates.get(privateId);
                            lieutenantGeneral.addPrivate(privateSoldier);
                        }
                    }
                    lieutenantGenerals.add(lieutenantGeneral);
                    break;
                case "Engineer":
                    double engineerSalary = Double.parseDouble(tokens[4]);
                    Corps engineerCorps;
                    try {
                        engineerCorps = Corps.valueOf(tokens[5]);
                    } catch (IllegalArgumentException e) {
                        line = scanner.nextLine();
                        continue;
                    }
                    Engineer engineer = new EngineerImpl(id, firstName, lastName, engineerSalary, engineerCorps);
                    for (int i = 6; i < tokens.length; i += 2) {
                        String repairPart = tokens[i];
                        int repairHours = Integer.parseInt(tokens[i + 1]);
                        Repair repair = new Repair(repairPart, repairHours);
                        engineer.addRepair(repair);
                    }
                    engineers.add(engineer);
                    break;
                case "Commando":
                    double commandoSalary = Double.parseDouble(tokens[4]);
                    Corps commandoCorps;
                    try {
                        commandoCorps = Corps.valueOf(tokens[5]);
                    } catch (IllegalArgumentException e) {
                        line = scanner.nextLine();
                        continue;
                    }
                    Commando commando = new CommandoImpl(id, firstName, lastName, commandoSalary, commandoCorps);
                    for (int i = 6; i < tokens.length; i += 2) {
                        String missionCodeName = tokens[i];
                        MissionState missionState;
                        try {
                            missionState = MissionState.valueOf(tokens[i + 1]);
                        } catch (IllegalArgumentException e) {
                            continue;
                        }
                        Mission mission = new Mission(missionCodeName, missionState);
                        commando.addMission(mission);
                    }
                    commandos.add(commando);
                    break;
                case "Spy":
                    String codeNumber = tokens[4];
                    Spy spy = new SpyImpl(id, firstName, lastName, codeNumber);
                    spies.add(spy);
                    break;
            }

            line = scanner.nextLine();
        }

        DecimalFormat df = new DecimalFormat("0.00");
        for (Private priv : privates.values()) {
            System.out.println(priv.toString());
        }
        for (LieutenantGeneral lieutenantGeneral : lieutenantGenerals) {
            System.out.println(lieutenantGeneral.toString());
        }
        for (Engineer engineer : engineers) {
            System.out.println(engineer.toString());
        }
        for (Commando commando : commandos) {
            System.out.println(commando.toString());
        }
        for (Spy spy : spies) {
            System.out.println(spy.toString());
        }
    }
}

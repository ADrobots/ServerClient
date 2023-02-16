public class Commands {
    String readCommands(String com){
        switch (com){
            case "dir":
                return "dir";
            case "cd":
                return "cd";
            default:
                return "command not found";
        }
    }

}

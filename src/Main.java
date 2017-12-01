
public class Main {

    public static void main(String[] args) {
        NumberGame ng = new NumberGame();
        ng.Prep();
        if(!ng.hasQuit())
            ng.Run();
        System.out.println("Quiting.");
    }
}

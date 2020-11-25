package pattern.decorator2;

public class StartBotTest {
    public static void main(String[] args) {
        botMade01();
        botMade02();
        botMade03();
        botMade04();
    }

    private static void botMade01() {
        BasicBot basicBot = new BasicBot();

        botTest(basicBot);
    }

    private static void botMade02() {
        BasicBot basicBot = new BasicBot();
        ImprovedAttackBot improvedAttackBot = new ImprovedAttackBot(basicBot);

        botTest(improvedAttackBot);
    }

    private static void botMade03() {
        BasicBot basicBot = new BasicBot();
        ImprovedSpeedBot improvedSpeedBot = new ImprovedSpeedBot(basicBot);

        botTest(improvedSpeedBot);
    }

    private static void botMade04() {
        BasicBot basicBot = new BasicBot();
        ImprovedAttackBot improvedAttackBot = new ImprovedAttackBot(basicBot);
        ImprovedSpeedBot improvedSpeedBot = new ImprovedSpeedBot(improvedAttackBot);

        botTest(improvedSpeedBot);
    }

    public static void botTest(IBot bot) {
        System.out.println("Receive Attack 20 !!");
        bot.downHp(20);

        System.out.println("Bot Speed Up Run !!");
        bot.run(10);

        System.out.println("Enemy Attack !!");
        int currentAttackPoint = bot.attack();
        System.out.println("Enemy Donw Heath Point : " + currentAttackPoint);

        System.out.println("Current Bot Status...");
        bot.currentStatus();
    }
}

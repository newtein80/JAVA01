package pattern.decorator1;

public class StartBotTest {
    public static void main(String[] args) {
        BasicBot basicBot = new BasicBot();
        AddOnJump advancedJumpBot = new AddOnJump(basicBot);
        AddOnFly advancedFlyBot = new AddOnFly(basicBot);
        AddOnShield advancedShieldBot = new AddOnShield(basicBot);

        // ! 위의 생성자에서 매개변수 클래스(bot)는 동일한 참조 주소를 갖는다.

        basicBot.run();
        basicBot.downHp(10);

        System.out.println(basicBot.getHp());

        advancedJumpBot.run();
        advancedJumpBot.downHp(10);

        System.out.println(basicBot.getHp());

        advancedFlyBot.run();
        advancedFlyBot.downHp(10);

        System.out.println(basicBot.getHp());

        advancedShieldBot.run();
        advancedShieldBot.downHp(10);

        System.out.println(basicBot.getHp());
        System.out.println(advancedJumpBot.getHp());
        System.out.println(advancedFlyBot.getHp());
        System.out.println(advancedShieldBot.getHp());
    }
}

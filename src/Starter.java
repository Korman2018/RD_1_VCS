import demoService.DemoService;
import demoService.DemoServiceImpl;

public class Starter {
    public static void main(String[] args) {

        DemoServiceImpl demoServiceImpl = new DemoServiceImpl();
        demoServiceImpl.showDemo();

    }
}
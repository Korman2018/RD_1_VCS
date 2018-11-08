import demoService.DemoService;
import demoService.DemoServiceImpl;

public class Start {
    public static void main(String[] args) {

        DemoServiceImpl demoServiceImpl = new DemoServiceImpl();
        demoServiceImpl.showDemo();

    }
}
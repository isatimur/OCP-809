package main.main.com.isatimur.ocp.advanced_java_class_designer;

/**
 * Created by Isa Timur on 7/25/16.
 */
public class StaffRegister {
    private static final StaffRegister instance;

    static {
        instance = new StaffRegister();
    }

    private StaffRegister() {
    }

    public StaffRegister getInstance() {
        return instance;
    }

}

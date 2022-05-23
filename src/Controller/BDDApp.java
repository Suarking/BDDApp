
package Controller;

import View.*;

public class BDDApp {

    public static void main(String[] args) throws Exception {
        
        MainWindow mainSPL = new MainWindow();
        SubwindowConnection subSPL = new SubwindowConnection();
        mainSPL.disabeall();
        subSPL.disableonstart();
        SubwindowConecctionControl subcontSPL = new SubwindowConecctionControl(subSPL, mainSPL);
        
        
        
    }
    
}

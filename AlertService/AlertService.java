package AlertService;

import java.util.Date;
import java.util.UUID;

/**
 * AlertService
 */
public class AlertService {
    private final AlertDAO storage;

    public AlertService(AlertDAO storage) {
        this.storage = storage;
    }
		
    public UUID raiseAlert() {
        return this.storage.addAlert(new Date());
    }
	
    public Date getAlertTime(UUID id) {
        return this.storage.getAlert(id);
    }	
}
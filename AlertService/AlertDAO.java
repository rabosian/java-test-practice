// Refactor the AlertService and MapAlertDAO classes:

// Create a new package-private interface, named AlertDAO, that contains the same methods as MapAlertDAO.
// MapAlertDAO should implement the AlertDAO interface.
// AlertService should have a public constructor that accepts AlertDAO.
// The raiseAlert and getAlertTime methods should use the object passed through the constructor.

package AlertService;

import java.util.Date;
import java.util.UUID;


public interface AlertDAO {
    UUID addAlert(Date time);
    Date getAlert(UUID id);
}

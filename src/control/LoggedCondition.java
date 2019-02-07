package control;

import java.io.Serializable;

public interface LoggedCondition extends Serializable{
	String getValue();
	String getOutcome();

}

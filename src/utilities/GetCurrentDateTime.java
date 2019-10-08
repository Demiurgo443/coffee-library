package utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GetCurrentDateTime {
	
	private static final DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yy");
	private static final DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	public static String data(){
		LocalDateTime now = LocalDateTime.now();
        return df.format(now);
	}
	public static String time() {
		LocalDateTime now = LocalDateTime.now();
        return tf.format(now);
	}
}

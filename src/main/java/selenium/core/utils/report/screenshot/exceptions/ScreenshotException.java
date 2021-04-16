package selenium.core.utils.report.screenshot.exceptions;

public class ScreenshotException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ScreenshotException(String msg) {
        super(msg);
    }

    public ScreenshotException(Exception e) {
        super(e);
    }

    public ScreenshotException(String msg, Exception e) {
        super(msg, e);
    }
}

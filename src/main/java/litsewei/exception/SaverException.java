package litsewei.exception;

/**
 * An exception thrown when the saver fails to save/load the taskManager.getTasks() to/from disk. <br/>
 * Usually caused by IO issues, such as the disk being full, or the file being corrupted. <br/>
 */
public class SaverException extends Exception{
    public SaverException(String message) {
        super(message);
    }
}

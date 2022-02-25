/**
 * ErrorFault.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */
package contacts;

public class ErrorFault extends java.lang.Exception {
    private static final long serialVersionUID = 1614343052866L;
    private contacts.Error faultMessage;

    public ErrorFault() {
        super("ErrorFault");
    }

    public ErrorFault(java.lang.String s) {
        super(s);
    }

    public ErrorFault(java.lang.String s, java.lang.Throwable ex) {
        super(s, ex);
    }

    public ErrorFault(java.lang.Throwable cause) {
        super(cause);
    }

    public void setFaultMessage(contacts.Error msg) {
        faultMessage = msg;
    }

    public contacts.Error getFaultMessage() {
        return faultMessage;
    }
}

/**
 * ContactsServiceMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */
package contacts;


/**
 *  ContactsServiceMessageReceiverInOut message receiver
 */
public class ContactsServiceMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver {
    public void invokeBusinessLogic(
        org.apache.axis2.context.MessageContext msgContext,
        org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault {
        try {
            // get the implementation class for the Web Service
            Object obj = getTheImplementationObject(msgContext);

            ContactsServiceSkeleton skel = (ContactsServiceSkeleton) obj;

            //Out Envelop
            org.apache.axiom.soap.SOAPEnvelope envelope = null;

            //Find the axisOperation that has been set by the Dispatch phase.
            org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext()
                                                                      .getAxisOperation();

            if (op == null) {
                throw new org.apache.axis2.AxisFault(
                    "Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
            }

            java.lang.String methodName;

            if ((op.getName() != null) &&
                    ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(
                            op.getName().getLocalPart())) != null)) {
                if ("getName".equals(methodName)) {
                    contacts.ContactGroup contactGroup10 = null;
                    contacts.Name wrappedParam = (contacts.Name) fromOM(msgContext.getEnvelope()
                                                                                  .getBody()
                                                                                  .getFirstElement(),
                            contacts.Name.class);

                    contactGroup10 = skel.getName(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            contactGroup10, false,
                            new javax.xml.namespace.QName("urn:Contacts",
                                "contactGroup"));
                } else
                 if ("getNumber".equals(methodName)) {
                    contacts.ContactGroup contactGroup12 = null;
                    contacts.Number wrappedParam = (contacts.Number) fromOM(msgContext.getEnvelope()
                                                                                      .getBody()
                                                                                      .getFirstElement(),
                            contacts.Number.class);

                    contactGroup12 = skel.getNumber(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            contactGroup12, false,
                            new javax.xml.namespace.QName("urn:Contacts",
                                "contactGroup"));
                } else {
                    throw new java.lang.RuntimeException("method not found");
                }

                newMsgContext.setEnvelope(envelope);
            }
        } catch (ErrorFault e) {
            msgContext.setProperty(org.apache.axis2.Constants.FAULT_NAME,
                "error");

            org.apache.axis2.AxisFault f = createAxisFault(e);

            if (e.getFaultMessage() != null) {
                f.setDetail(toOM(e.getFaultMessage(), false));
            }

            throw f;
        }
        catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    //
    private org.apache.axiom.om.OMElement toOM(contacts.Name param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(contacts.Name.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(contacts.ContactGroup param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(contacts.ContactGroup.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(contacts.Error param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(contacts.Error.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(contacts.Number param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(contacts.Number.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory, contacts.ContactGroup param,
        boolean optimizeContent, javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    contacts.ContactGroup.MY_QNAME, factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private contacts.ContactGroup wrapgetName() {
        contacts.ContactGroup wrappedElement = new contacts.ContactGroup();

        return wrappedElement;
    }

    private contacts.ContactGroup wrapgetNumber() {
        contacts.ContactGroup wrappedElement = new contacts.ContactGroup();

        return wrappedElement;
    }

    /**
     *  get the default envelope
     */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory) {
        return factory.getDefaultEnvelope();
    }

    private java.lang.Object fromOM(org.apache.axiom.om.OMElement param,
        java.lang.Class type) throws org.apache.axis2.AxisFault {
        try {
            if (contacts.ContactGroup.class.equals(type)) {
                return contacts.ContactGroup.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (contacts.Error.class.equals(type)) {
                return contacts.Error.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (contacts.Name.class.equals(type)) {
                return contacts.Name.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (contacts.Number.class.equals(type)) {
                return contacts.Number.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }
        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

        return null;
    }

    private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();

        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }
} //end of class

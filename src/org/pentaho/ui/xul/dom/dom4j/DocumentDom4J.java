/**
 * 
 */
package org.pentaho.ui.xul.dom.dom4j;

import org.pentaho.ui.xul.XulComponent;
import org.pentaho.ui.xul.XulDomContainer;
import org.pentaho.ui.xul.XulException;
import org.pentaho.ui.xul.dom.Document;
import org.pentaho.ui.xul.dom.Element;
/**
 * @author NBaker
 *
 */
public class DocumentDom4J extends ElementDom4J implements Document {

  private org.dom4j.Document document;
  private XulDomContainer container;
  public DocumentDom4J(){
    super();
    this.document = org.dom4j.DocumentHelper.createDocument();
    this.element = this.document.getRootElement();
  }
  
  public DocumentDom4J(org.dom4j.tree.DefaultDocument document){
    super();
    this.document = document;
    this.element = document.getRootElement();
  }
  
  /* (non-Javadoc)
   * @see org.pentaho.ui.xul.dom.Document#getRootElement()
   */
  public XulComponent getRootElement() {
    // TODO Auto-generated method stub
    return ((XulElementDom4J) document.getRootElement()).getXulElement();
  }

  @Override
  public void addChild(Element ele) {
    // TODO Auto-generated method stub
    document.add((org.dom4j.Element) ele.getElementObject());
    this.element = (org.dom4j.Element) ele.getElementObject();
  }
  
  public XulComponent createElement(String elementName) throws XulException{
  	return this.container.getXulLoader().createElement(elementName);
  }

	public void setXulDomContainer(XulDomContainer container) {
		this.container = container;
		
	}

	public boolean isRegistered(String elementName) {
		return this.container.getXulLoader().isRegistered(elementName);
	}
  
}

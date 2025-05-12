package com.myapp.struts;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class LogForm extends ActionForm {
    
    private String name;
    private String error;
    private String valor;
    private FormFile file;
   
    public FormFile getFile() {
		return file;
	}
	public void setFile(FormFile file) {
		this.file = file;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getName() {
        return name;
    }
    public void setName(String string) {
        name = string;
    }

    public void setError(String error) {
    	 this.error = "<span style='color:red'>"+error+"</span>";
    }
     public String getError() {
        return error;
    }   

    /***/
    public LogForm() {
        super();
    }
     
     /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
 /* public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getName() == null || getName().length() < 1) {
            errors.add("name", new ActionMessage("errors.name.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
    }
   */
}

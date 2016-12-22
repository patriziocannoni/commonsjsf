package br.com.cannoni.commons.jsf.view;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class ViewUtil {

	private static final String CODIGO_ARQUIVOS_MENSAGEM = "msgs";

	/**
	 * Construtor.
	 */
	private ViewUtil() {
		super();
	}

	/**
	 * Obtem o resource bundle da aplicação.
	 * 
	 * @return {@link ResourceBundle}
	 */
	public static ResourceBundle getResourceBundle() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ResourceBundle resourceBundle = facesContext.getApplication().getResourceBundle(facesContext,
				CODIGO_ARQUIVOS_MENSAGEM);
		return resourceBundle;
	}

	/**
	 * Adiciona uma mensagem do jsf no faces context.
	 * 
	 * @param message
	 *            String com a mensagem
	 * @param severity
	 *            Severity da mensagem
	 */
	private static void addBusinessMessage(final String message, final Severity severity) {
		FacesMessage facesMessage = new FacesMessage(severity, null, message);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}

	/**
	 * Mensagem de erro.
	 * 
	 * @param message
	 *            String com a mensagem
	 */
	public static void addErrorMessage(String message) {
		addBusinessMessage(message, FacesMessage.SEVERITY_ERROR);
	}

	/**
	 * Mensagem informativa.
	 * 
	 * @param message
	 *            String com a mensagem
	 */
	public static void addInfoMessage(String message) {
		addBusinessMessage(message, FacesMessage.SEVERITY_INFO);
	}

}

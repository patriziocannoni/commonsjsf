package br.com.cannoni.commons.jsf.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * @author Patrizio
 * @since 01/08/2013
 */
@FacesValidator("br.com.cannoni.EmailValidator")
public class EmailValidator implements Validator {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\."
			+ "[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*" + "(\\.[A-Za-z]{2,})$";

	private Pattern pattern;

	private Matcher matcher;

	/**
	 * Construtor
	 */
	public EmailValidator() {
		super();
		pattern = Pattern.compile(EMAIL_PATTERN);
	}

	@Override
	public void validate(FacesContext contexto, UIComponent componente, Object valor) throws ValidatorException {
		matcher = pattern.matcher(valor.toString());

		if (!matcher.matches()) {
			FacesMessage msg = new FacesMessage("Falha na validação do e-mail", "Formato do email inválido");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}

}

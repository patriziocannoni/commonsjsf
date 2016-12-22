package br.com.cannoni.commons.jsf.view;

import javax.annotation.PostConstruct;

/**
 * Abstração do ManagedBean para JSF, com métodos comuns a todos os beans.
 * 
 * @author Patrizio
 * @since 02/08/2013
 */
public abstract class AbstractManagedBean {

	/**
	 * Construtor.
	 */
	public AbstractManagedBean() {
		super();
	}

	/**
	 * Inicializa as propriedade do ManagedBean.
	 */
	@PostConstruct
	private void init() {
		inicializarPropriedades();
	}

	/**
	 * Inicializa as propriedades do ManagedBean.
	 */
	protected abstract void inicializarPropriedades();

}

package com.algaworks.brewer.validation.validator;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintValidatorContext.ConstraintViolationBuilder;

import com.algaworks.brewer.validation.AtributoConfirmacao;

import org.apache.commons.beanutils.BeanUtils;

public class AtributoConfirmacaoValidator implements ConstraintValidator<AtributoConfirmacao, Object> {

    private String atributo;

    private String atributoConfirmacao;

    @Override
    public void initialize(AtributoConfirmacao constraintAnnotation) {

        this.atributo = constraintAnnotation.atributo();
        this.atributoConfirmacao = constraintAnnotation.atributoConfirmacao();

    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {

        boolean valido = false;

        try {
            Object valorAtributo = BeanUtils.getProperty(object, this.atributo);
            Object valorAtributoConfimacao = BeanUtils.getProperty(object, this.atributoConfirmacao);

            valido = ambosSaoNull(valorAtributo, valorAtributoConfimacao) || ambosSaoIguais(valorAtributo, valorAtributoConfimacao);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao recuperar os valores dos atributos", e);
        }

        if(!valido){
            context.disableDefaultConstraintViolation();
            String mensagem = context.getDefaultConstraintMessageTemplate();
            ConstraintViolationBuilder violationBuilder = context.buildConstraintViolationWithTemplate(mensagem);
            violationBuilder.addPropertyNode(atributoConfirmacao).addConstraintViolation();
        }

        return valido;
    }

    private boolean ambosSaoIguais(Object valorAtributo, Object valorAtributoConfimacao) {
        return valorAtributo != null && valorAtributo.equals(valorAtributoConfimacao);
    }

    private boolean ambosSaoNull(Object valorAtributo, Object valorAtributoConfimacao) {
        return valorAtributo == null && valorAtributoConfimacao == null ;
    }



}

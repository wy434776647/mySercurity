/**
 * 
 */
package com.zmor.core.validata.code.sms;

import com.zmor.core.properties.SecurityProperties;
import com.zmor.core.validata.code.ValidateCode;
import com.zmor.core.validata.code.ValidateCodeGenerator;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author zhailiang
 *
 */
@Component("smsValidateCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {

	@Autowired
	private SecurityProperties securityProperties;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.imooc.security.core.validate.code.ValidateCodeGenerator#generate(org.
	 * springframework.web.context.request.ServletWebRequest)
	 */
	@Override
	public ValidateCode generate(ServletWebRequest request) {
		String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
		return new ValidateCode(code, securityProperties.getCode().getSms().getExpireIn());
	}

	public SecurityProperties getSecurityProperties() {
		return securityProperties;
	}

	public void setSecurityProperties(SecurityProperties securityProperties) {
		this.securityProperties = securityProperties;
	}
	
	

}

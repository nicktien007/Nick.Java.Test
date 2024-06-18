package com.nick.javatest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

@Slf4j
@RequiredArgsConstructor
public class Nick_5 {
	@Test
	void test_normalInvoke() {
		//正常的操作
		OtpService otpService = new OtpService();
		String mobile = "09xx";

		OtpEntity otpEntity = otpService.sendOTP(mobile);

		String otpTimeTextColor = getOtpTimeTextColor(otpEntity.getTxId());
		log.info(otpTimeTextColor);
	}

	@Test
	void test_otpText_Red() {
		MockOtpServiceRed mockOtpService = new MockOtpServiceRed();
		String mobile = "09xx";
		OtpEntity otpEntity = mockOtpService.sendOTP(mobile);

		String actual = getOtpTimeTextColor(otpEntity.getTxId());
		String expected = "Red";

		Assert.assertEquals(expected, actual);
		log.info(actual);
	}

	@Test
	void test_otpText_Green() {
		MockOtpServiceGreen mockOtpService = new MockOtpServiceGreen();
		String mobile = "09xx";
		OtpEntity otpEntity = mockOtpService.sendOTP(mobile);

		String actual = getOtpTimeTextColor(otpEntity.getTxId());
		String expected = "Green";

		Assert.assertEquals(expected, actual);
		log.info(actual);
	}

	private String getOtpTimeTextColor(String txId) {
		if (txId == "COTAG010") {
			return "Red";
		}

		if (txId == "COTAG008") {
			return "Green";
		}

		return "Black";
	}

}

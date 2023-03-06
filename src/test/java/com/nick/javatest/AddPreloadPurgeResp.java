package com.nick.javatest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class AddPreloadPurgeResp {

	@JsonProperty("result")
	private String result;

//	@JsonProperty("remains_quota")
//	private int remainsQuota;

	@JsonProperty("job_info")
	private List<JobInfoInfo> jobInfo;

	@NoArgsConstructor
	@Data
	public static class JobInfoInfo {

		/**
		 * 工作序號
		 */
		@JsonProperty("job_id")
		private String jobId;

		/**
		 * 內容預載(或單檔快取清除)網址
		 */
		@JsonProperty("url")
		private String url;
	}
}

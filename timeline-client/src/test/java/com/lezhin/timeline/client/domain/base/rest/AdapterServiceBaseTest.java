package com.lezhin.timeline.client.domain.base.rest;

import com.lezhin.timeline.client.domain.activity.dto.ActivityLogSearchConditions;
import org.fest.assertions.api.Assertions;
import org.fest.assertions.data.MapEntry;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Map;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AdapterServiceBaseTest {

	@Spy
	private AdapterServiceBase adapterServiceBase;

	@Test
	@Ignore
	public void buildUrl_파라미터_일부_존재() {
		ActivityLogSearchConditions conditions = new ActivityLogSearchConditions();
		conditions.setLoginId("test");
		conditions.setPage(3);

		String baseUrl = "http://localhost:19011";
		when(adapterServiceBase.getBaseUrl()).thenReturn(baseUrl);

		String path = "/activities";
		String url = adapterServiceBase.buildUrl(path, conditions);
		Assertions.assertThat(url).startsWith(baseUrl + path + "?");
		Assertions.assertThat(url).contains("loginId={loginId}");
		Assertions.assertThat(url).contains("page={page}");
		Assertions.assertThat(url).doesNotContain("size={size}");
//		Assertions.assertThat(url).isEqualTo(baseUrl + path + "?loginId={loginId}&page={page}");

	}

	@Test
	@Ignore
	public void buildUrl_파라미터_전체_존재() {
		ActivityLogSearchConditions conditions = new ActivityLogSearchConditions();
		conditions.setLoginId("test");
		conditions.setPage(3);
		conditions.setSize(1);

		String baseUrl = "http://localhost:19011";
		when(adapterServiceBase.getBaseUrl()).thenReturn(baseUrl);

		String path = "/activities";
		String url = adapterServiceBase.buildUrl(path, conditions);
		Assertions.assertThat(url).startsWith(baseUrl + path + "?");
		Assertions.assertThat(url).contains("loginId={loginId}");
		Assertions.assertThat(url).contains("page={page}");
		Assertions.assertThat(url).contains("size={size}");
//		Assertions.assertThat(url).isEqualTo(baseUrl + path + "?loginId={loginId}&page={page}&size={size}");
	}

	@Test
	public void buildParameters_파라미터_일부_존재() {
		ActivityLogSearchConditions conditions = new ActivityLogSearchConditions();
		conditions.setLoginId("test");
		conditions.setPage(3);

		Map<String, Object> params = adapterServiceBase.buildParameters(conditions);
		Assertions.assertThat(params).hasSize(2);
		Assertions.assertThat(params).contains(MapEntry.entry("loginId", conditions.getLoginId()));
		Assertions.assertThat(params).contains(MapEntry.entry("page", conditions.getPage()));
	}

	@Test
	public void buildParameters_파라미터_전체_존재() {
		ActivityLogSearchConditions conditions = new ActivityLogSearchConditions();
		conditions.setLoginId("test");
		conditions.setPage(3);
		conditions.setSize(1);

		Map<String, Object> params = adapterServiceBase.buildParameters(conditions);
		Assertions.assertThat(params).hasSize(3);
		Assertions.assertThat(params).contains(MapEntry.entry("loginId", conditions.getLoginId()));
		Assertions.assertThat(params).contains(MapEntry.entry("page", conditions.getPage()));
		Assertions.assertThat(params).contains(MapEntry.entry("size", conditions.getSize()));
	}

}
package com.nick.javatest;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

public class HamcrestTest {
	@Test
	void demoHamcrest() {

		//=========================================核心匹配===============================================//
		// allOf: 所有條件都必須滿足，相當於&&
		assertThat("myname", allOf(startsWith("my"), containsString("name")));

		// anyOf: 其中一個滿足就通過， 相當於||
		assertThat("myname", anyOf(startsWith("na"), containsString("name")));

		// both: &&
		assertThat("myname", both(containsString("my")).and(containsString("me")));

		// either: 兩者之一
		assertThat("myname", either(containsString("my")).or(containsString("you")));

		// everyItem: 每個元素都需滿足特定條件
		assertThat(Arrays.asList("my", "mine"), everyItem(startsWith("m")));

		// hasItem: 是否有這個元素
		assertThat(Arrays.asList("my", "mine"), hasItem("my"));

		// hasItems: 包含多個元素
		assertThat(Arrays.asList("my", "mine", "your"), hasItems("your", "my"));

		// is: is(equalTo(x))或is(instanceOf(clazz.class))的簡寫
		assertThat("myname", is("myname"));
		assertThat("mynmae", instanceOf(String.class));

		// anything(): 任何情況下，都匹配正確
		assertThat("myname", anything());

		// not: 否為真，相當於！
		assertThat("myname", is(not("you")));

		// nullValue(): 值為空
		String str = null;
		assertThat(str, is(nullValue()));

		// notNullValue(): 值不為空
		String str2 = "123";
		assertThat(str2, is(notNullValue()));
		//=========================================核心匹配===============================================//




		//=========================================字串匹配===============================================//
		// containsString：包含字串
		assertThat("myname", containsString("na"));

		// stringContainsInOrder: 順序包含，“my”必須在“me”前面
		assertThat("myname", stringContainsInOrder(Arrays.asList("my", "me")));

		// endsWith: 後綴
		assertThat("myname", endsWith("me"));

		// startsWith: 前綴
		assertThat("myname", startsWith("my"));

		// isEmptyString(): 空字串
		assertThat("", emptyString());

		// equalTo: 值相等， Object.equals(Object)
		assertThat("myname", equalTo("myname"));
		assertThat(new String[] {"a", "b"}, equalTo(new String[] {"a", "b"}));

		// equalToIgnoringCase: 比較時，忽略大小寫
		assertThat("myname", equalToIgnoringCase("MYNAME"));

		// equalToCompressingWhiteSpace: 比較時， 首尾空格忽略， 比較時中間用單個空格
		assertThat(" my \t name ", equalToCompressingWhiteSpace(" my name "));

		// oneOf: 是否為其中之一
		assertThat("myname", oneOf("myname", "yourname"));

		// in: 是否為其成員
		assertThat("myname", in(new String[]{"myname", "yourname"}));

		// toString() 返回值校驗
		assertThat(333, hasToString(equalTo("333")));
		//=========================================字串匹配===============================================//




		//=========================================數值匹配===============================================//
		// closeTo: [operand-error, operand+error], Double或BigDecimal類型
		assertThat(3.14, closeTo(3, 0.5));
		assertThat(new BigDecimal("3.14"), is(closeTo(new BigDecimal("3"), new BigDecimal("0.5"))));

		// comparesEqualTo: compareTo比較值
		assertThat(2, comparesEqualTo(2));

		// greaterThan： 大於
		assertThat(2, greaterThan(0));

		// greaterThanOrEqualTo: 大於等於
		assertThat(2, greaterThanOrEqualTo(2));

		// lessThan: 小於
		assertThat(0, lessThan(2));

		// lessThanOrEqualTo: 小於等於
		assertThat(0, lessThanOrEqualTo(0));
		//=========================================數值匹配===============================================//





		//=========================================集合匹配===============================================//
		// array: 陣列長度相等且對應元素也相等
		assertThat(new Integer[]{1, 2, 3}, is(array(equalTo(1), equalTo(2), equalTo(3))));

		// hasItemInArray: 陣列是否包含特定元素
		assertThat(new String[]{"my", "you"}, hasItemInArray(startsWith("y")));

		// arrayContainingInAnyOrder， 順序無關，長度要一致
		assertThat(new String[]{"my", "you"}, arrayContainingInAnyOrder("you", "my"));

		// arrayContaining:  順序，長度一致
		assertThat(new String[]{"my", "you"}, arrayContaining("my", "you"));

		// arrayWithSize: 陣列長度
		assertThat(new String[]{"my", "you"}, arrayWithSize(2));

		// emptyArray: 空陣列
		assertThat(new String[0], emptyArray());

		// hasSize: 集合大小
		assertThat(Arrays.asList("my", "you"), hasSize(equalTo(2)));

		// empty: 空集合
		assertThat(new ArrayList<String>(), is(empty()));

		// isIn: 是否為集合成員
		assertThat("myname", in(Arrays.asList("myname", "yourname")));

		// Map匹配
		Map<String, String> myMap = new HashMap<>();
		myMap.put("name", "john");

		// hasEntry: key && value匹配
		assertThat(myMap, hasEntry("name", "john"));

		// hasKey: key匹配
		assertThat(myMap, hasKey(equalTo("name")));

		// hasValue: value匹配
		assertThat(myMap, hasValue(equalTo("john")));
		//=========================================集合匹配===============================================//

	}
}

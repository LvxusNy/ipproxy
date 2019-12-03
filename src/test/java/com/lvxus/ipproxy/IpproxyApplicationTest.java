package com.lvxus.ipproxy;

import com.lvxus.ipproxy.utils.CommonUtil;
import com.lvxus.ipproxy.utils.ConnectUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
public class IpproxyApplicationTest {

    @Test
    public void get_random_user_agent() {
        String userAgent = CommonUtil.getRandomUserAgent();
        System.out.println(userAgent);
    }

    @Test
    public void get_random_number() {
        Object randomNum = CommonUtil.getRandomNumWithUserAgents();
        System.out.println(randomNum);
    }

    @Test
    public void url_connection() {
        String url = "https://www.kuaidaili.com/free/inha/4/";
        CommonUtil.getConnectionHtmlResult(null, null, url, null);
    }

    @Test
    public void regex_html_target() {
        String regex = "<td[^>]*>([^<]*)</td>";
        String str = "<tr>\n" +
                "                    <td data-title=\"IP\">183.164.239.22</td>\n" +
                "                    <td data-title=\"PORT\">9999</td>\n" +
                "                    <td data-title=\"匿名度\">高匿名</td>\n" +
                "                    <td data-title=\"类型\">HTTP</td>\n" +
                "                    <td data-title=\"位置\">安徽省淮北市  电信</td>\n" +
                "                    <td data-title=\"响应速度\">1秒</td>\n" +
                "                    <td data-title=\"最后验证时间\">2019-11-28 06:31:01</td>\n" +
                "                </tr>";

        List<String> results = CommonUtil.getRegexHtmlResults(regex, str);
        for (String result :
                results) {
            System.out.println(result);
        }

    }

    @Test
    public void regex_true_html_target() {
        String url = "https://www.kuaidaili.com/free/inha/4/";
        String regex = "<td data-title=\"[IP]*[PORT]*\"[^>]*>([^<]*)</td>";
        String connection = CommonUtil.getConnectionHtmlResultOnlyUrl(url);
        List<String> regexResults = CommonUtil.getRegexHtmlResults(regex, connection);
        for (int i = 0; i < regexResults.size(); i++) {
            System.out.println(regexResults.get(i) + ":" + regexResults.get(++i));
        }

    }

    @Test
    public void regex_ip() {
        String ip = "117.88.177.192";
        Assert.assertTrue(CommonUtil.regexIp(ip));

    }

    @Test
    public void connect_with_proxy_ip() {
        String ip = "36.248.129.114";
        String port = "9999";
        String url = "https://www.kuaidaili.com/free/inha/4/";
        String regex = "<td data-title=\"[IP]*[PORT]*\"[^>]*>([^<]*)</td>";
        String connection = CommonUtil.getConnectionHtmlResultOnlyUrl(url);
        List<String> regexResults = CommonUtil.getRegexHtmlResults(regex, connection);
        for (int i = 0; i < regexResults.size(); i++) {
            String result = CommonUtil.getConnectionHtmlResult(regexResults.get(i), Integer.parseInt(regexResults.get(++i)), "http://ip.tool.chinaz.com/", null);
            System.out.println(result);
        }
    }

    @Test
    public void proxy_connect_by_httpclient() {
        String connectUrl = "http://ip.tool.chinaz.com/";
        String url = "https://www.kuaidaili.com/free/inha/3/";
        String connection = CommonUtil.getConnectionHtmlResultOnlyUrl(url);
        String regex = "<td data-title=\"[IP]*[PORT]*\"[^>]*>([^<]*)</td>";
        List<String> regexResults = CommonUtil.getRegexHtmlResults(regex, connection);
        ConnectUtils.proxyConnectByHttpClient(connectUrl,regexResults);

    }


}

package com.qlmsoft.mbp.test;

import com.qlmsoft.mbp.common.utils.Encodes;
import com.qlmsoft.mbp.common.utils.XmlBuilder;
import com.qlmsoft.mbp.common.utils.XmlDecodeUtil;
import com.qlmsoft.mbp.modules.project.bean.DataTableProjectInfo;

/**
 * Created by aaronhuang on 2018/8/21.
 */
public class ProjectTest {
    public static void main(String[] args) {

        String a = "<dataTable><row><PKID>MDY3M2MwZTMtZmVhMy00Nzc3LWI5NWYtZDBiNWY1MTMxZDhi</PKID><PrjNum>MzIwMjExMTgwODIwMDEwMQ==</PrjNum><PrjInnerNum>MjAxODEwMjY=</PrjInnerNum><PrjName>WERHLTIwMTQtNDC6xbXYv+m/qreivajJ6M/uxL8=</PrjName><PrjTypeNum>MDE=</PrjTypeNum><BuildCorpName>zt7O/c3ytO+zx82218rT0M/euavLvg==</BuildCorpName><BuildCorpCode>MDg5MzE0ODctMw==</BuildCorpCode><ProvinceNum>MzIwMDAw</ProvinceNum><CityNum>MzIwMjAw</CityNum><CountyNum>MzIwMjEx</CountyNum><PrjApprovalNum></PrjApprovalNum><PrjApprovalLevelNum>MDA0</PrjApprovalLevelNum><BuldPlanNum>tdjX1rXaMzIwMjExMjAxOEEwMDMwusU=</BuldPlanNum><ProjectPlanNum></ProjectPlanNum><AllInvest>NTU4MDkuNTUwMA==</AllInvest><AllArea>NjYwMDAuMDA=</AllArea><PrjSize></PrjSize><PrjPropertyNum>MDAx</PrjPropertyNum><PrjFunctionNum>MTAw</PrjFunctionNum><BDate>MjAxOC0xMC0wMQ==</BDate><EDate>MjAxOS0wNi0yOQ==</EDate><CREATEDATE>MjAxOC0wOC0yMA==</CREATEDATE><UpdateFlag>VQ==</UpdateFlag><sbdqbm>MzIwMjAw</sbdqbm><prjpassword>d3gyMDE4MTAyNg==</prjpassword><gyzzpl>MC4wMDAw</gyzzpl><dzyx>MTk0NjM5MzZAcXEuY29t</dzyx><lxr>1cW98L3c</lxr><yddh>MTgwNjE5MDkwOTk=</yddh><xmtz>NTU4MDkuNTUwMA==</xmtz><gytze>MC4wMDAw</gytze><gytzbl>MC4wMDAw</gytzbl><lxtzze>NTU4MDkuNTUwMA==</lxtzze><programme_address>xM+6/rGxwrexsbLg</programme_address></row><row><PKID>ZWU4YzZlYjgtNTM4Zi00NzkzLWIwZTktNDgxODZkNzZlNjQ4</PKID><PrjNum>MzIwMjExMTgwODE2MDEwMQ==</PrjNum><PrjInnerNum>MjAxODEwMTY=</PrjInnerNum><PrjName>WERHLTIwMTctMji6xbXYv+m9qMnoz+7Evw==</PrjName><PrjTypeNum>MDE=</PrjTypeNum><BuildCorpName>zt7O/crQvM62sNbD0rXT0M/euavLvg==</BuildCorpName><BuildCorpCode>OTEzMjAyMTFNQTFXVUdYMDVK</BuildCorpCode><ProvinceNum>MzIwMDAw</ProvinceNum><CityNum>MzIwMjAw</CityNum><CountyNum>MzIwMjEx</CountyNum><PrjApprovalNum>MjAxOC0zMjAyMTEtNzAtMDItMzQzNjM2</PrjApprovalNum><PrjApprovalLevelNum>MDAz</PrjApprovalLevelNum><BuldPlanNum></BuldPlanNum><ProjectPlanNum></ProjectPlanNum><AllInvest>MTMxMjUzLjAwMDA=</AllInvest><AllArea></AllArea><PrjSize></PrjSize><PrjPropertyNum>MDAx</PrjPropertyNum><PrjFunctionNum>MTAw</PrjFunctionNum><BDate>MjAxOC0wOS0yNQ==</BDate><EDate>MjAyMC0xMS0zMA==</EDate><CREATEDATE>MjAxOC0wOC0xNg==</CREATEDATE><UpdateFlag>VQ==</UpdateFlag><sbdqbm>MzIwMjAw</sbdqbm><prjpassword>d3gyMDE4MTAxNg==</prjpassword><gyzzpl>MzAuMDAwMA==</gyzzpl><dzyx>OTQwMzAwNTk1QHFxLmNvbQ==</dzyx><lxr>wO7F4Lnj</lxr><yddh>MTgwMTU4MjEzMTk=</yddh><xmtz>MTMxMjUzLjAwMDA=</xmtz><gytze>MC4wMDAw</gytze><gytzbl>MC4wMDAw</gytzbl><lxtzze>MTMxMjUzLjAwMDA=</lxtzze><programme_address>zt7O/crQsfW6/sf41tzQwsK30+vBotDFtPO1wL27sua/2g==</programme_address></row></dataTable>";

        String decodeStr = XmlDecodeUtil.xmlStrToObject(a, Encodes.ENCODING_GBK);
        DataTableProjectInfo result = (DataTableProjectInfo) XmlBuilder.xmlStrToObject(DataTableProjectInfo.class, decodeStr);
        System.out.println(result.toString());

    }
}

package com.isatimur.ocp;

import com.google.common.base.Joiner;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        ConcurrentHashMap<String, String> fields = new ConcurrentHashMap<>();
        fields.put("FAKS", "факс");
        fields.put("TEL_WORK", "телефон рабочий");
        fields.put("BRANCH", "N подразделения (не согласован с АС филиалом)");
        fields.put("DOP_VZNOS_USD", "сумма доп. взноса в долларах");
        fields.put("ACC_DATE1", "дата открытия счета");
        fields.put("RP_BIRTH", "дата рождения");

        String text = "<HTML><HEAD><TITLE>Условия по размещению денежных средств во вклад</TITLE>\n<META content=\"text/html; charset=windows-1251\" http-equiv=Content-Type>\n<META name=GENERATOR content=\"MSHTML 8.00.7601.18870\"></HEAD>\n<BODY><!-- HEADER CENTER \"$PAGE\" --><!-- FOOTER CENTER \"\n\n\nДоговор о счете N _____/_____\" -->\n\n<!-- MEDIA TOP 13mm -->\n\n<!-- FOOTER LEFT\n{IS_BFO?\"\n\nБАНК __________________________\n(подпись работника БАНКА)\"\n&amp;\n\"\n\nБАНК Подписано ЭП _____\n_____\"}-->\n\n<!-- FOOTER RIGHT \n{IS_BFO?\"\n\nВКЛАДЧИК (ПРЕДСТАВИТЕЛЬ)_________________________\n(подпись)\"\n&amp;\n\"\n\nВКЛАДЧИК (ПРЕДСТАВИТЕЛЬ) Подписано ЭП _____\n_____\nкарта N _____\n_____\"}-->\n\n\n<DIV align=left><BR></DIV>\n<DIV align=right><BR></DIV>\n<TABLE border=0 cellSpacing=0 cellPadding=7 width=\"100%\">\n  <TBODY>\n  <TR>\n    <TD vAlign=top width=\"80%\" align=left><IMG src=\"/db/LogoStamp.spr\"></TD>\n    <TD vAlign=center width=\"20%\" align=right>Код 012111065/6 \n</TD></TR></TBODY></TABLE>\n<CENTER>\n<P><B>ДОГОВОР N</B> <B>_____<BR>О ВКЛАДЕ </B><B>\"_____\"</B></P></CENTER>\n<TABLE border=0 cellSpacing=0 cellPadding=7 width=\"100%\">\n  <TBODY>\n  <TR>\n    <TD height=19 vAlign=top width=\"50%\" align=left>г. _____ </TD>\n    <TD height=19 vAlign=top width=\"50%\" align=right>_____ \n      года. </TD></TR></TBODY></TABLE>\n<P align=justify><B>ПУБЛИЧНОЕ АКЦИОНЕРНОЕ ОБЩЕСТВО \"СБЕРБАНК РОССИИ\"</B>, \nименуемое в дальнейшем <B>\"БАНК\"</B>, с одной стороны, и <B>_____</B>, именуемый \nв дальнейшем <B>\"ВКЛАДЧИК\"</B>, с другой стороны, заключили настоящий Договор о \nнижеследующем:<BR></P>\n<DIV align=center><B>1. ПРЕДМЕТ ДОГОВОРА<BR><BR></B></DIV>\n<DIV align=justify>1.1.<B> ВКЛАДЧИК</B> вносит, а <B>БАНК</B> принимает денежные \nсредства (вклад) в сумме и валюте&nbsp; согласно Договору, обязуется возвратить \nсумму вклада и выплатить&nbsp; причитающиеся проценты на условиях&nbsp; и в \nпорядке, предусмотренных Договором. Для учета денежных средств, вносимых \n<B>ВКЛАДЧИКОМ</B> на основании Договора, <B>БАНК</B> открывает <B>ВКЛАДЧИКУ</B> \nсчет вклада.<BR>1.2. К вкладу применяются Условия размещения вкладов (далее - \nУсловия) и Тарифы <B>БАНКА</B> за совершение операций по счету вклада (далее - \nТарифы), действующие на дату подписания Договора, а при его пролонгации - на \nдату пролонгации Договора. Вкладчик ознакомлен и согласен с Условиями и \nТарифами.<BR>1.3. <B>БАНК</B> информирует <B>ВКЛАДЧИКА</B> об изменении Условий, \nТарифов, а также об изменении процентных ставок по вкладу посредством размещения \nсоответствующих сведений в подразделениях <B>БАНКА</B>, осуществляющих операции \nпо вкладам физических лиц в доступном для ознакомления вкладчиков месте, на \nофициальном сайте <B>БАНКА</B> в сети Интернет.<BR>1.4. <B>ВКЛАДЧИК</B> поручает \n<B>БАНКУ</B> перечислять со счета вклада суммы, предусмотренные пунктом 3.2.1.1. \nУсловий, а также в иных случаях, установленных настоящим Договором. </DIV><BR>\n<DIV align=center><B>2. ОСНОВНЫЕ УСЛОВИЯ ДОГОВОРА&nbsp;</B></DIV>\n<DIV align=justify>2.1. Сумма и валюта вклада: _____ _____.<BR>2.2. \nСрок вклада: _____.<BR>2.3. Дата окончания срока вклада: _____ \nгода.<BR>2.4. Процентная ставка по вкладу: _____.<BR>2.5. Приходные операции \nпо вкладу: _____.<BR>2.6. Минимальный размер дополнительного взноса, \nвносимого наличными деньгами: _____.<BR>2.7. Периодичность внесения \nдополнительных взносов: _____.<BR>2.8. Расходные операции по вкладу: \n_____.<BR>2.9. Сумма неснижаемого остатка: _____.<BR>2.10. Периодичность \nпричисления/выплаты процентов: _____.<BR>2.11. Порядок уплаты процентов: \n_____.<BR>2.12. Порядок начисления дохода при досрочном востребовании \nвклада: _____.<BR>2.13. Количество пролонгаций Договора на новый срок: \n_____.<BR>2.14. <B>ВКЛАДЧИК</B> _____ на \nперечисление процентов, выплачиваемых в соответствии с Договором, на счет \nбанковской карты/ на другой счет вклада, открытый в <B>БАНКЕ</B>. \n_____<!--\n<br>\nНомер банковской карты для перечисления процентов по вкладу: <b>_____</b><br>\n--> <BR><BR></DIV>\n\n<P align=center><B>3. АДРЕСА И РЕКВИЗИТЫ СТОРОН</B><BR></P>\n\n<P align=justify><B>ВКЛАДЧИК: <U>_____</U></B><BR></P>адрес регистрации: \n&nbsp;<U>_____<BR></U>адрес фактического проживания (для почтовых \nотправлений): <U>_____<BR></U>адрес электронной почты: _____<BR>ИНН (при \nналичии) <U>_____</U> гражданство <U>_____</U><BR>вид документа, \nудостоверяющего личность: <U>_____</U> \n<TABLE border=0 cellSpacing=0 width=\"100%\">\n  <TBODY>\n  <TR>\n    <TD width=\"31%\">серия&nbsp; \n<U>_____&nbsp;N&nbsp;_____&nbsp;</U></TD>\n    <TD width=763>\n      <P align=justify>кем,где,когда выдан&nbsp;<U>_____</U><U><BR></U>код \n      подразделения (при наличии) \n<U>_____</U><U><BR></U></P></TD></TR></TBODY></TABLE>вид и реквизиты \nдокумента, подтверждающего право на пребывание (проживание) в Российской \nФедерации <U><U>_____</U><BR></U>данные миграционной карты \n<U><U>_____</U><BR></U>\n<DIV align=justify>дата и место рождения <U><U>_____г. \n_____</U><BR></U></DIV>телефон <U><U>_____</U></U> факс (при \nналичии)&nbsp;<U><U>_____</U><BR><BR></U>\n<TABLE border=1 cellSpacing=2 cellPadding=2 width=342 height=61>\n  <TBODY>\n  <TR>\n    <TD vAlign=top>{ SIGN_PLACE}_____<BR></TD></TR></TBODY></TABLE>&nbsp; &nbsp; &nbsp; \n&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; \n(подпись) \n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \n<U><BR>\n\n\n_____ <!--\n\n<br>\n<b>ПРЕДСТАВИТЕЛЬ ВКЛАДЧИКА:</b>\n&nbsp;<b><u>_____&nbsp;</u></b>\n<p align=\"justify\">адрес регистрации: <u>_____</u>&nbsp;<br>\nадрес фактического проживания (для почтовых\nотправлений):<u> _____ </u><br>\n</p>\n<p align=\"justify\">ИНН (при наличии) <u>_____</u>&nbsp; гражданство <u>_____<br>\n</u></p>\n<p align=\"justify\">вид документа, удостоверяющего личность: <u>_____</u></p>\n<table border=\"0\" cellspacing=\"0\" width=\"100%\">\n<tbody>\n<tr>\n<td width=\"31%\">&nbsp;\nсерия <u>_____</u></td>\n<td width=\"763\"><p align=\"justify\">кем,где,когда\n&nbsp;<u>_____</u>&nbsp; <u><br>\n      </u>код подразделения (при наличии) <u>_____<br>\n      </u></p>\n</td>\n</tr></tbody>\n</table>\n\nвид и реквизиты документа, подтверждающего&nbsp; право на пребывание (проживание) в Российской Федерации <u>_____</u><br>\n\nданные миграционной карты <u>_____</u><br>\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n<br>\nдата и место рождения <u>_____</u><br>\nтелефон<u>&nbsp; _____</u>________ факс (при наличии)&nbsp; <u>_____</u><br>\n\n_____\n\n<br>\n<table border=\"1\" cellpadding=\"2\" cellspacing=\"2\" height=\"79\" width=\"316\">\n<tbody>\n<tr>\n<td valign=\"top\">_____<br>\n</td></tr></tbody></table>\n--></U>\n<P align=justify><B>БАНК:</B> Филиал <U>_____</U> структурное подразделение \nN <U>_____/_____</U>&nbsp;<BR>почтовый адрес \n&nbsp;<U>_____</U>&nbsp;<BR>местонахождение &nbsp;<U>_____</U> \n<U><BR></U>телефон <U>_____</U><BR></P>\n<TABLE border=0 cellSpacing=0 width=\"100%\">\n  <TBODY>\n  <TR>\n    <TD vAlign=top width=\"33%\"><BR></TD>\n    <TD width=\"24%\" align=middle>\n      <P align=center><B><U>_____<BR></U></B><BR></P></TD>\n    <TD width=171><BR></TD>\n    <TD width=\"28%\" align=middle>\n      <P align=center>{IS_BFO?&amp;БАНК Подписано ЭП\n_____ _____}<BR><BR></P></TD></TR>\n  <TR>\n    <TD width=361><BR></TD>\n    <TD width=260><BR></TD>\n    <TD width=171 align=middle>М.П.</TD>\n    <TD width=304 align=middle><BR></TD></TR></TBODY></TABLE></BODY></HTML>\n";
        String regex = "([{][a-zA-Z[._-] ]+[}])";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(text);
//        Map<String, String> map = new HashMap<>();
//        while (matcher.find()) {
//            String replaceText = matcher.group();
//            String keyToReplace = replaceText.split("[{]")[1].split("[}]")[0];
//            map.put("{" + keyToReplace + "}", fields.getOrDefault(keyToReplace, " "));
//        }
//        for (String key : map.keySet()) {
//            char[] arrayOfChars = key.toCharArray();
//            String joiner = Joiner.on("][").join(arrayOfChars);
//            if (joiner != null && joiner.length() > 0) {
//                String regex = "[" + joiner + "]";
//                text = text.replaceAll(regex, map.get(key));
//            }
//        }
        text = text.replaceAll(regex,"_____");
        String regexPast = "[{][ a-zA-Z[._-] ]+[?].*[}]";
        text = text.replaceAll(regexPast,"_____");
        String regexLastPast = "[{][ a-zA-Z[._-] ]+[?]";
        text = text.replaceAll(regexLastPast,"_____");
        text = text.replaceAll("[}]","");

        System.out.println(text);

//        fields = getContractFields();
//        String text = contractTemplate.getTEXT();
//        String regex = "([{][a-zA-Z[._-] ]+[}])";
//        String regexPast = "[{][ a-zA-Z[._-] ]+[?].*[}]";
//        String regexLastPast = "[{][ a-zA-Z[._-] ]+[?]";
        //        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(text);
//        Map<String, String> map = new HashMap<>();
//        while (matcher.find()) {
//            String replaceText = matcher.group();
//            String keyToReplace = replaceText.split("[{]")[1].split("[}]")[0];
//            map.put("{" + keyToReplace + "}", fields.get(keyToReplace));
//        }
//        for (String key : map.keySet()) {
//            String[] arrayOfChars = key.split("");
//            String joiner = Joiner.on("][").join(arrayOfChars);
//            if (joiner != null && joiner.length() > 0) {
//                String regex = "[" + joiner + "]";
//                text = text.replaceAll(regex, map.get(key));
//            }
//        }

//        text = text
//                .replaceAll(regex, "_____")
//                .replaceAll(regexPast, "_____")
//                .replaceAll(regexLastPast, "_____")
//                .replaceAll("[}]", "")
//                .replaceAll("(\r\n|\n)", "<br />");
//        contractTemplate.setTEXT(text);

    }
}

/*
 * Copyright 2021-2021 Alex Therapeutics AB and individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */

package com.alextherapeutics.diga.implementation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;

class DigaHealthInsuranceDirectoryFromXmlTest {
  private static final String sampleInsuranceCompanyMappingXml =
      """
          <?xml version="1.0" encoding="UTF-8"?>
          <n1:Kostentraeger_Mappingverzeichnis xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:n1="http://www.gkv-datenaustausch.de/XML-Schema/EDRE0_MVZ/3.0" xmlns:bas="http://www.gkv-datenaustausch.de/XMLSchema/EDFC0-basis/3.0" version="003.000.000" gueltigab="2022-08-25" xsi:schemaLocation="http://www.gkv-datenaustausch.de/XML-Schema/EDRE0_MVZ/3.0 EDRE0-MVZ_3.0.0.xsd">
              <n1:Krankenkasseninformation Nummer="ID1">
                  <bas:Kostentraegerkuerzel>CH</bas:Kostentraegerkuerzel>
                  <bas:Kostentraegerkennung>109034277</bas:Kostentraegerkennung>
                  <bas:Name_des_Kostentraegers>Test BKK</bas:Name_des_Kostentraegers>
                  <bas:IK_des_Rechnungsempfaengers>009034270</bas:IK_des_Rechnungsempfaengers>
                  <bas:IK_Abrechnungsstelle>060500345</bas:IK_Abrechnungsstelle>
                  <bas:Name_Kommunikationsstelle>DIGA-TEST1</bas:Name_Kommunikationsstelle>
                  <bas:Endpunkt_Kommunikationsstelle>diga.test1-daten.de</bas:Endpunkt_Kommunikationsstelle>
                  <bas:Versandart>1</bas:Versandart>
                  <bas:Postalische_Zusaetze>Test BKK</bas:Postalische_Zusaetze>
                  <bas:Strasse_Postfach>Test Str.</bas:Strasse_Postfach>
                  <bas:Hausnummer_Postfachnummer>6</bas:Hausnummer_Postfachnummer>
                  <bas:PLZ>88130</bas:PLZ>
                  <bas:Ort>Testort</bas:Ort>
                  <bas:Kontaktdaten_Technisch_Telefon>0000-24862725</bas:Kontaktdaten_Technisch_Telefon>
                  <bas:Kontaktdaten_Technisch_EMail>servicedesk@test.de</bas:Kontaktdaten_Technisch_EMail>
              </n1:Krankenkasseninformation>
              <n1:Krankenkasseninformation Nummer="ID2" gueltig_ab="2021-03-15" gueltig_bis="2022-03-15" nachfolge_kostentraegerkuerzel="CH" insolvenz="N">
                  <bas:Kostentraegerkuerzel>DH</bas:Kostentraegerkuerzel>
                  <bas:Kostentraegerkennung>008444448</bas:Kostentraegerkennung>
                  <bas:Name_des_Kostentraegers>Betriebskrankenkasse</bas:Name_des_Kostentraegers>
                  <bas:IK_des_Rechnungsempfaengers>108433848</bas:IK_des_Rechnungsempfaengers>
                  <bas:IK_Abrechnungsstelle>060000345</bas:IK_Abrechnungsstelle>
                  <bas:Name_Kommunikationsstelle>DIGA-TEST2</bas:Name_Kommunikationsstelle>
                  <bas:Endpunkt_Kommunikationsstelle>diga.test2-daten.de</bas:Endpunkt_Kommunikationsstelle>
                  <bas:Versandart>1</bas:Versandart>
                  <bas:Postalische_Zusaetze>z. Hd. Herrn Mustermann</bas:Postalische_Zusaetze>
                  <bas:Strasse_Postfach>Teststrasse</bas:Strasse_Postfach>
                  <bas:Hausnummer_Postfachnummer>35</bas:Hausnummer_Postfachnummer>
                  <bas:PLZ>80339</bas:PLZ>
                  <bas:Ort>München</bas:Ort>
                  <bas:Kontaktdaten_Technisch_Telefon>0000-24862725</bas:Kontaktdaten_Technisch_Telefon>
                  <bas:Kontaktdaten_Technisch_EMail>servicedesk@test.de</bas:Kontaktdaten_Technisch_EMail>
              </n1:Krankenkasseninformation>
          </n1:Kostentraeger_Mappingverzeichnis>
          """;

  @Test
  void createsWithoutError() {
    assertDoesNotThrow(
        () ->
            DigaHealthInsuranceDirectoryFromXml.getInstance(
                new ByteArrayInputStream(
                    sampleInsuranceCompanyMappingXml.getBytes(StandardCharsets.UTF_8))));
  }
}

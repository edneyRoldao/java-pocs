package com.edn.base;

public class Teste2 {

    String s = "CLIENTE DEPOSITANTE (somente numeros);CANAL (somente numeros);Referencia (somente numeros);NOME DO BENEFICIARIO (apenas texto sem caracteres especiais e acentos);COD. BANCO (somente numeros);AGENCIA (numero com dígito separado por -);CONTA (numero com dígito separado por -);TIPO CONTA (CORRENTE/POUPANCA);CPF/CNPJ (ate 18 digitos com  . / -);TIPO PESSOA (JURIDICA/FISICA);VALOR (numero com centavos separado por virgula)\n" +
            "122309;357;1355;DATASYSTEM TECNOLOGIA SISTEMA;237;3381;2221-7;CORRENTE;15.407.008/0001-44;JURIDICA;460007,5\n" +
            "122309;357;1351;CNTA;104;2997;003001312-0;CORRENTE;16.707.014/0001-80;JURIDICA;102713,25\n" +
            "122309;357;1363;FETRABENS;104;273;00331164-9;CORRENTE;65.884.710/0001-77;JURIDICA;48876,0\n" +
            "122309;357;1374;SINDICAM SP;104;273;003000254-2;CORRENTE;57.660.334/0001-09;JURIDICA;13868,0\n" +
            "122309;357;1352;SINDICAM-PR;104;2997;003000515-2;CORRENTE;79.643.235/0001-51;JURIDICA;77198,0\n" +
            "122309;357;1353;SINDICAM PR;104;2997;003000248-0;CORRENTE;79.643.235/0001-51;JURIDICA;4814,0\n" +
            "122309;357;1414;Federação dos Caminhoneiros Autonomos e Transportadores Rodoviarios Autonomos de Bens do Estado de Santa Catarina;104;420;2861-2;CORRENTE;12.742.863/0001-13;JURIDICA;6230,5\n" +
            "122309;357;1357;Sindicato dos Transportadores Rodoviarios Autonomos de Bens do Estado de Santa Catarina;104;420;1248-1;CORRENTE;78.477.072/0001-11;JURIDICA;14018,25\n" +
            "122309;357;1356;Sindicato dos Caminhoneiros Autonomos e Transportadores Autonomos de bens de Chapeco;104;414;4438-0;CORRENTE;11.086.383/0001-89;JURIDICA;1844,0\n" +
            "122309;357;1358;Sindicato dos Transportadores Autonomos de Bens e Cargas Merc Porto Mun de Sao Francisco do Sul;104;424;1228-9;CORRENTE;79.356.986/0001-97;JURIDICA;4080,0\n" +
            "122309;357;1359;Sindicato dos Caminhoneiros Autonomos e Transportadores Rodoviarios Autonomos de Bens de Palhoca;104;3521;497-4;CORRENTE;16.755.398/0001-06;JURIDICA;2448,0\n" +
            "122309;357;1360;Sindicato dos Caminhoneiros Autonomos e Transportadores Rodoviarios Autonomos de Bens de Pouso Redondo;133;5055;4699-0;CORRENTE;12.126.333/0001-40;JURIDICA;7446,0\n" +
            "122309;357;1361;Sindicato dos Transportadores Autonomos de Containeres e Cargas em Geral de Itajai e Regiao;104;416;3247-2;CORRENTE;06.072.036/0001-67;JURIDICA;3077,18\n" +
            "122309;357;1362;Sindicato dos Caminhoneiros Autonomos e Transportadores Rodoviarios Autonomos de Bens de Itaiopolis;1;7978;35800-2;CORRENTE;11.998.701/0001-88;JURIDICA;1326,0\n" +
            "122309;357;1376;SETRAM - Sindicato das Empresas de Logística e Transporte de Cargas da Região da Amurel;85;108;152-0;CORRENTE;06.070.311/0001-03;JURIDICA;250,0\n" +
            "122309;357;1367;SINTRAVIR - Sindicato das Empresas de Transporte Rodoviario de Cargas e Logística de Videira e Regiao;1;403;173106-8;CORRENTE;01.481.532/0001-50;JURIDICA;560,0\n" +
            "122309;357;1354;Sindicato das Empresas de Transporte Rodoviários de Cargas do Vale do Canoinhas;104;413;1093-6;CORRENTE;02.679.234/0001-32;JURIDICA;1190,0\n" +
            "122309;357;1375;SETCOM - Sindicato das Empresas de Transporte de Cargas do Oeste e Meio Oeste Catarinense;756;3288;159-7;CORRENTE;75.319.780/0001-36;JURIDICA;1260,0\n" +
            "122309;357;1364;SETCESC - Sindicato das Empresas de Transporte de Cargas e Logística no Estado de SC;85;108;241-0;CORRENTE;82.662.776/0001-31;JURIDICA;110,0\n" +
            "122309;357;1365;Sindicato das Empresas de Transportes de Cargas e Logística do Sul de Santa Catarina;85;108;122-8;CORRENTE;79.939.831/0001-83;JURIDICA;3300,0\n" +
            "122309;357;1366;Cooperimtra - Cooperativa de Transportadores Autonomos Logistica e Armazenamento de Imbituba e Regiao;1;1408;17316-9;CORRENTE;10.266.189/0001-12;JURIDICA;87,07\n" +
            "122309;357;1368;FECONE;104;220;129-6;CORRENTE;06.314.577/0001-54;JURIDICA;24002,0\n" +
            "122309;357;1369;SINDICAM BA;104;672;003001752-2;CORRENTE;40.480.857/0001-70;JURIDICA;975,0\n" +
            "122309;357;1370;SINDICAM BA;104;672;003001752-2;CORRENTE;40.480.857/0001-70;JURIDICA;928,0\n" +
            "122309;357;1371;SINDICAM BA;104;672;003001752-2;CORRENTE;40.480.857/0001-70;JURIDICA;849,0\n" +
            "122309;357;1372;SINDICAM BA;104;672;003001752-2;CORRENTE;40.480.857/0001-70;JURIDICA;440,0\n" +
            "122309;357;1373;SINDICAM-BA;104;672;003001752-2;CORRENTE;40.480.857/0001-70;JURIDICA;1509,0\n" +
            "122309;357;1377;SINDICAM-BA;104;672;003001752-2;CORRENTE;40.480.857/0001-70;JURIDICA;4326,0\n" +
            "122309;357;1378;SINDICAM-BA;104;672;003001752-2;CORRENTE;40.480.857/0001-70;JURIDICA;991,0\n" +
            "122309;357;1379;SINDICAM-BA;104;672;003001752-2;CORRENTE;40.480.857/0001-70;JURIDICA;1070,0\n" +
            "122309;357;1380;SINDICAM-BA;104;672;003001752-2;CORRENTE;40.480.857/0001-70;JURIDICA;976,0\n" +
            "122309;357;1381;SINDICAM BA;104;672;003001752-2;CORRENTE;40.480.857/0001-70;JURIDICA;2516,0\n" +
            "122309;357;1382;SINDICAM CE;104;578;003000709-7;CORRENTE;10.622.491/0001-66;JURIDICA;4029,0\n" +
            "122309;357;1383;SINDICAM MA;104;3273;003000910-3;CORRENTE;10.271.884/0001-72;JURIDICA;2108,0\n" +
            "122309;357;1384;SINDICAM MA;104;3273;003000910-3;CORRENTE;10.271.884/0001-72;JURIDICA;378,0\n" +
            "122309;357;1385;SINDICAM MA;104;3273;003000910-3;CORRENTE;10.271.884/0001-72;JURIDICA;110,0\n" +
            "122309;357;1386;SINDITAC AGRESTE;104;561;003000889-9;CORRENTE;10.962.076/0001-51;JURIDICA;2281,0\n" +
            "122309;357;1387;SINDITAC LEM;104;2734;0030001045-7;CORRENTE;12.620.376/0001-88;JURIDICA;1464,0\n" +
            "122309;357;1388;SINDITAC PARAIBA;104;36;0030004334-7;CORRENTE;11.144.521/0001-39;JURIDICA;4625,0\n" +
            "122309;357;1396;SINDITAC PB SS.Campina Grande;104;36;003001267-0;CORRENTE;11.144.521/0002-10;JURIDICA;3476,0\n" +
            "122309;357;1395;SINDITAC PI;104;1989;003002682-0;CORRENTE;11.101.970/0001-08;JURIDICA;1904,0\n" +
            "122309;357;1389;SINTRACAPE;237;3209;080290-5;CORRENTE;10.737.735/0001-56;JURIDICA;1715,0\n" +
            "122309;357;1397;SINDICATO DOS TRANSP NAVEGANTES;104;1879;0130058372-8;POUPANCA;13.624.698/0001-68;JURIDICA;10788,0\n" +
            "122309;357;1391;Altair Mendonca Jacinto;104;425;0165356-6;CORRENTE;298.346.279-04;FISICA;918,0\n" +
            "122309;357;1392;Solani Balbinot;104;702;64961-7;CORRENTE;605.081.169-53;FISICA;204,0\n" +
            "122309;357;1394;Ademir Luiz Possamai;237;385;23522-9;CORRENTE;440.075.829-04;FISICA;612,0\n" +
            "122309;357;1393;Iolanda Ventura Fernandes;104;535;013003908-0;CORRENTE;560.587.139-00;FISICA;918,0\n" +
            "122309;357;1416;SIND. TRANSP. AUT. DE BENS DO EST. DO ACRE;104;3320;003003122-7;CORRENTE;64.911.803/0001-80;JURIDICA;220,0\n" +
            "122309;357;1404;FETRAMIG;104;1639;003002765-2;CORRENTE;13.367.500/0001-08;JURIDICA;24385,0\n" +
            "122309;357;1407;VIACAO MARVIN LTDA;104;4157;003003321-9;CORRENTE;22.891.614/0001-43;JURIDICA;3287,0\n" +
            "122309;357;1403;SINDICAM MONTES CLAROS;104;3115;003000347-4;CORRENTE;11.038.719/0001-38;JURIDICA;4971,0\n" +
            "122309;357;1405;SIND PONTENOVA;104;146;003000777-2;CORRENTE;11.322.404/0001-18;JURIDICA;4120,0\n" +
            "122309;357;1411;SINDITAC GOVERNADOR VALADARES;104;1642;003001885-4;CORRENTE;10.952.112/0001-04;JURIDICA;330,0\n" +
            "122309;357;1412;SINDITAC JUIZ DE FORA;104;3398;003000155-2;CORRENTE;10.926.389/0001-54;JURIDICA;6464,0\n" +
            "122309;357;1406;ELVIS ALCANTARA DE ALMEIDA;341;3040;25650-9;CORRENTE;011.179.066-20;FISICA;4655,0\n" +
            "122309;357;1415;SINDITAC PB;104;36;003001267-0;CORRENTE;11.144.521/0002-10;JURIDICA;63,0\n" +
            "122309;357;1400;JEOVA PEREIRA;104;1445;0130017316-3;POUPANCA;213.306.039-15;FISICA;1762,0\n" +
            "122309;357;1401;DELLAPAR TRANSPORTES E LOGISTICA LTDA;1;2755;24568-2;CORRENTE;03.284.099/0001-99;JURIDICA;24354,0\n" +
            "122309;357;1402;Patricia Rodrigues Laurini ME;104;2086;003009252-4;CORRENTE;13.469.193/0001-76;JURIDICA;3823,0\n" +
            "122309;357;1413;SINDICAM TRES LAGOAS;237;2100;1001950-8;CORRENTE;799.315.371-91;FISICA;1998,0\n" +
            "122309;357;1408;ROSA MARIA BREDA BARBOSA;104;1540;013054315-3;POUPANCA;577.795.707-20;FISICA;3585,0\n" +
            "122309;357;1398;JHONNY ERICK CONRADI DIAS;237;2471;1004283-6;POUPANCA;082.848.719-71;FISICA;18214,0\n" +
            "122309;357;1409;SEBASTIAO GOMES RODRIGUES;104;1539;013000440-0;CORRENTE;342.093.527-72;FISICA;3271,0\n" +
            "122309;357;1399;Francisco Wilde Bittencourt Ferreira;104;197;36081-4;CORRENTE;469.828.767-72;FISICA;5962,0\n" +
            "122309;357;1410;SAMARA DA SILVA GELAIN;104;3630;0030021044-9;CORRENTE;140.326.807-01;FISICA;2501,0\n" +
            "122309;357;1390;OSNY CARLOS BELLINATI;237;73;0604630-4;CORRENTE;106.550.181-15;FISICA;13293,0\n" +
            "122309;357;1436;RITA DE CASSIA NALLI MAZIOLI LOUVEM;104;1306;003005011-8;CORRENTE;880.977.307-15;FISICA;7439,0\n" +
            "122309;357;1437;AYLTON JOSE JUNIOR;756;3007;25698-6;CORRENTE;034.906.477-69;FISICA;1572,0\n" +
            "122309;357;1417;SINDICAM PARANAGUA;33;4574;1300325-8;CORRENTE;79.625.869/0001-81;JURIDICA;1448,0\n" +
            "122309;357;1418;SINDICAM DF;104;2407;0030031048-7;CORRENTE;26.445.379/0001-37;JURIDICA;2877,0\n" +
            "122309;357;1438;SINDICAM DOURADOS;237;1101;2736-7;CORRENTE;12.056.223/0001-50;JURIDICA;4248,0\n" +
            "122309;357;1419;Roberto Pessoa Costa ME;237;1461;052372-0;CORRENTE;37.455.425/0001-03;JURIDICA;9835,0\n" +
            "122309;357;1420;Roberto Pessoa Costa ME;237;1461;0052372-0;CORRENTE;37.455.425/0001-03;JURIDICA;3069,0\n" +
            "122309;357;1421;SINDICAM PA;341;8523;19972-0;CORRENTE;09.199.060/0001-50;JURIDICA;2029,0\n" +
            "122309;357;1422;JOSE ROBERTO RIBEIRO;237;379;0064585-0;CORRENTE;285.648.138-82;FISICA;535,0\n" +
            "122309;357;1423;VICENTE CHIMENES;33;206;01013398-3;CORRENTE;305.906.631-00;FISICA;5097,0\n" +
            "122309;357;1424;VZS SERVICOS COMBINADOS\n" + ";104;4988;00300927-8;CORRENTE;35.223.355/0001-24;JURIDICA;23743,0\n" +
            "122309;357;1447;SINDICAM CAMPOS DOS GOYTACAZES;104;180;003001650-5;CORRENTE;10.702.450/0001-80;JURIDICA;1305,0\n" +
            "122309;357;1433;SINDITAC OS;104;925;003005675-1;CORRENTE;10.746.715/0001-41;JURIDICA;330,0\n" +
            "122309;357;1434;SINDITAC TRES RIOS;104;195;003000638-2;CORRENTE;11.368.787/0001-65;JURIDICA;472,0\n" +
            "122309;357;1435;SINDITAC ARARUAMA;104;888;003001671-7;CORRENTE;10.950.455/0001-21;JURIDICA;613,0\n" +
            "122309;357;1425;Giovanni Bruel Maurer;1;4314;52100-0;CORRENTE;762.403.209-00;FISICA;1353,0\n" +
            "122309;357;1439;SINDITAC TATUI;104;359;003000625-1;CORRENTE;11.305.553/0001-79;JURIDICA;629,0\n" +
            "122309;357;1440;SINDICATO MOGI DAS CRUZES;104;3357;10-2;CORRENTE;21.572.406/0001-19;JURIDICA;3334,0\n" +
            "122309;357;1426;SINDICAM GO (RIO VERDE);104;3419;0130017818-5;POUPANCA;11.295.119/0001-55;JURIDICA;10069,0\n" +
            "122309;357;1427;SINDICAM SORRISO;104;2756;003000250-0;CORRENTE;12.138.308/0001-87;JURIDICA;4786,0\n" +
            "122309;357;1428;SINDITAC SUDOESTE PR;104;601;003004553-7;CORRENTE;11.393.340/0001-46;JURIDICA;2202,0\n" +
            "122309;357;1429;MOVIA CONSULTORIA E HOLDING EIRELI;341;4416;43360-7;CORRENTE;29.130.547/0001-93;JURIDICA;9972,0\n" +
            "122309;357;1430;SINDICAM BARRA DO GARCAS;104;1308;0030002908-6;CORRENTE;22.418.010/0001-84;JURIDICA;3446,0\n" +
            "122309;357;1431;SINDITAC SUDESTE;104;564;003003366-0;CORRENTE;10.906.222/0001-21;JURIDICA;3792,0\n" +
            "122309;357;1432;SINDITAC FORMOSA;104;4500;003000586-3;CORRENTE;23.315.637/0001-72;JURIDICA;7253,0\n" +
            "122309;357;1441;SINDICAM CANARANA;1;1319;19568-5;CORRENTE;12.417.624/0001-98;JURIDICA;1039,0\n" +
            "122309;357;1442;SINDITAC CMR;104;386;003002951-8;CORRENTE;10.976.521/0001-32;JURIDICA;2691,0\n" +
            "122309;357;1443;SICATRACON RONDONIA;104;4326;003000433-0;CORRENTE;11.283.869/0001-07;JURIDICA;5083,0\n" +
            "122309;357;1467;SINDICAM ES;104;1539;00300623-6;CORRENTE;04.415.328/0001-20;JURIDICA;1887,0\n" +
            "122309;357;1444;SINDCCACEAM;104;2853;003001185-0;CORRENTE;11.960.245/0001-87;JURIDICA;8240,0\n" +
            "122309;357;1468;SINDITAC GUARAPUAVA;104;389;003005270-2;CORRENTE;11.068.910/0001-22;JURIDICA;1542,0\n" +
            "122309;357;1445;SINDITAC ASTORGA;104;1318;00300954-3;CORRENTE;10.917.483/0001-47;JURIDICA;409,0\n" +
            "122309;357;1446;SIDITAC PG;104;1757;003001113-8;CORRENTE;10.623.533/0001-83;JURIDICA;1904,0\n" +
            "122309;357;1469;SINDITAC TOLEDO;104;726;003004032-2;CORRENTE;11.023.847/0001-08;JURIDICA;1195,0\n" +
            "122309;357;1448;SINDIGRAN GUARUJA;237;525;74272-4;CORRENTE;68.011.642/0001-20;JURIDICA;315,0\n" +
            "122309;357;1449;SINDICAM SANTOS;104;3048;003001214-3;CORRENTE;57.731.937/0001-54;JURIDICA;2486,0\n" +
            "122309;357;1450;SINDICAM ARACATUBA;104;281;003000485-9;CORRENTE;00.447.376/0001-49;JURIDICA;1400,0\n" +
            "122309;357;1451;SINDICAM PACAEMBU;237;1135;5990-0;CORRENTE;21.544.928/0001-07;JURIDICA;12316,0\n" +
            "122309;357;1452;SINDICAM SJRIO PRETO;237;1135;4910-7;CORRENTE;13.040.064/0001-68;JURIDICA;1321,0\n" +
            "122309;357;1453;SINDITAC SJC;104;2741;03000535-4;CORRENTE;10.868.987/0001-14;JURIDICA;2107,0\n" +
            "122309;357;1454;SINDICAM ARARAS;104;283;003003078-8;CORRENTE;12.972.701/0001-71;JURIDICA;11335,0\n" +
            "122309;357;1455;SINDICAM RIBEIRAO PRETO;104;2947;00300692-0;CORRENTE;13.042.433/0001-51;JURIDICA;3051,0\n" +
            "122309;357;1456;SIND. TRANSP. AUT. CARGAS DE GUARULHOS;104;3295;003000344-0;CORRENTE;11.656.711/0001-35;JURIDICA;6762,0\n" +
            "122309;357;1457;cnta;104;2997;0003001312-0;CORRENTE;16.707.014/0001-80;JURIDICA;6116,5\n" +
            "122309;357;1458;Sindicato Transp. Autonomos de Cargas de Ijui;748;361;80392-8;CORRENTE;10.926.372/0001-05;JURIDICA;2250,0\n" +
            "122309;357;1459;NAILTON ALVES DA SILVA;237;389;28230-8;CORRENTE;210.671.394-00;FISICA;110,0\n" +
            "122309;357;1460;SINDITAC INTERIOR;104;3016;3509-2;CORRENTE;26.071.974/0001-50;JURIDICA;4481,0\n" +
            "122309;357;1461;FEDERACAO DOS CAMINHONEIROS AUTONOMOS DE CARGA;104;224;2836-6;CORRENTE;11.076.651/0001-81;JURIDICA;25144,0\n" +
            "122309;357;1462;SINDICAM RJ ES ;237;3370;166000-4;CORRENTE;31.170.335/0001-81;JURIDICA;7832,0\n" +
            "122309;357;1463;SINDITAC D.de Caxias ;104;4881;003000013-9;CORRENTE;11.807.513/0001-25;JURIDICA;3349,0\n" +
            "122309;357;1464;GLOBAL LIMP COMERCIO E SERVICOS LTDA;237;25763;0096520-0;CORRENTE;28.695.749/0001-10;JURIDICA;23054,0\n" +
            "122309;357;1465;SINDITAC SAO GONCALO ;104;3028;003001957-2;CORRENTE;19.141.774/0001-60;JURIDICA;1698,0\n" +
            "122309;357;1466;SINDLAGOS ;341;8595;18622-5;CORRENTE;00.368.582/0001-63;JURIDICA;63,0\n" +
            "122309;357;1470;FELIPE DE FREITAS;341;9626;01846-0;CORRENTE;076.356.109-61;FISICA;55743,0\n" +
            "122309;357;1471;MARCELO LESSA BARROSO ME;1;4247;12509-1;CORRENTE;06.890.027/0001-83;JURIDICA;16809,0\n" +
            "122309;357;1472;EDILSON CORDEIRO DE ASSIS;748;2302;7288-5;CORRENTE;118.407.733-91;FISICA;393,0\n" +
            "122309;357;1473;Fernando Campos B. da Silva ME;77;1;2800596-1;CORRENTE;08.157.971/0002-32;JURIDICA;1573,0\n" +
            "122309;357;1474;FERNANDO CAMPOS B. DA SILVA ME;1;1836;43055-2;CORRENTE;08.157.971/0001-51;JURIDICA;6701,0\n" +
            "122309;357;1475;FERNANDO CAMPOS B. DA SILVA ME;77;1;2800596-1;CORRENTE;08.157.971/0002-32;JURIDICA;1683,0\n" +
            "122309;357;1476;FETAC-ES FEDERACAO INTERESTADUAL DOS TRANSPORTADORES AUTONOMOS DE CARGAS NA REGIAO SUDESTE DO BRASIL;104;3630;003000938-3;CORRENTE;19.648.734/0001-00;JURIDICA;7017,5\n" +
            "122309;357;1484;N/D;104;0;000000-0;CORRENTE;10.959.970/0001-72;JURIDICA;2092,0\n" +
            "122309;357;1483;PAULO RICARDO RODRIGUES - ME;237;1451;8552-9;CORRENTE;24.269.699/0001-58;JURIDICA;9747,0\n" +
            "122309;357;1481;SONIA MARIA MONTANARI HERNANDES ME;341;771;07278-2;CORRENTE;24.522.565/0001-05;JURIDICA;7496,3\n" +
            "122309;357;1477;Rosi Maria Montanari Cursi ME;33;4193;13000666-3;CORRENTE;11.868.294/0001-94;JURIDICA;9718,0\n" +
            "122309;357;1478;SONIA MARIA MONTANARI HERNANDES ME;341;771;07278-2;CORRENTE;24.522.565/0001-05;JURIDICA;24193,0\n" +
            "122309;357;1479;SUB SEDE SJC;104;2741;03000535-4;CORRENTE;10.868.987/0001-14;JURIDICA;110,0\n" +
            "122309;357;1480;SINDCAM TIMOTEO;104;2296;003002019-3;CORRENTE;11.168.294/0001-81;JURIDICA;7424,0\n" +
            "122309;357;1485;Federacao das Empresas de Transporte de Carga e Logistica no Estado de SC;85;108;30-2;CORRENTE;81.347.908/0001-78;JURIDICA;870,0\n" +
            "122309;357;1482;SINDICAM SP;104;273;003000254-2;CORRENTE;57.660.334/0001-09;JURIDICA;3212,7\n";

    public static void main(String[] args) {
        System.out.println(new Teste2().s.length());
    }

}

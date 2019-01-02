<h1><center>Desafio de Engenheiro de Dados</h1></center>

O presente projeto contém o script para a performace de ETL nas bases encaminhadas.

Scala foi a linguagem utilizada para o desenvolvimento do Script.

Inserir o caminho dos arquivos de logs utilizando <code>SparkContex.textFile(path_dos_arquivos_/logs/*)</code>

Após alterar o parâmetro do textFile, gerar o .jar (o mesmo será salvo na pasta target > scala-2.11) no sbt e executar via <b>spark-submit</b>.

Foi utilizado a seguinte biblioteca para efetuar as operações nos dataframes:
<code> import org.apache.spark.sql.functions._ </code>

<h1>Respostas das perguntas encaminhadas via PDF:</h1>

1 - Qual o objetivo do comando cache em Spark?
- Cache em Spark é um mecanismo para executar de forma mais rápida as requisições de aplicações que utilizam os mesmos RDD's.

2 - O mesmo código implementado em Spark é normalmente mais rápido que a implementação equivalente em
MapReduce. Por quê?
- Spark e MapReduce são duas ferramentas utilizadas para realizar o processamento de dados. No entando, o que torna o Spark mais rápido é a sua abordagem quanto ao processamento de dados. Enquando o MapReduce primeiro lê e guarda em disco, a ferramenta Spark faz todas as operações em memória, tornando-se mais rápida e vantajosa.

3 - Qual a função do SparkContext 
- SparkContext representa a conexão de um cluster Spark e pode ser usado para a criação de RDD's, acumuladores e variáveis de broadcast.

4- Explique com suas palavras o que é Resilient Distributed Datasets (RDD).
- Resilient Distributed Dataset também conhecido como RDD é uma abstração de dados principal da ferramenta Apache Spark. RDD funciona basicamente como uma coleção de dados em python ou scala por exemplo.

5 - GroupByKey é menos eficiente que reduceByKey em grandes dataset. Por quê?
- Ao contrário de groupByKey, reduceByKey não mistura os dados no início de sua execução. 

6 - Explique o que o código Scala abaixo faz.

<code>val textFile = sc.textFile("hdfs://...")</code> - Lê um ariquivo do diretório HDFS

<code>val counts = textFile.flatMap(line => line.split(" "))</code> - Cria uma coleção de itens a partir de um espaço delimitados

<code>map(word => (word, 1))</code> - É criado um mapeamento chave valor onde a palavra é a chave e o número 1 é um valor que será utilizado em outro passo

<code>reduceByKey(_ + _) </code> - Nesse momento é iniciada a ação, é realizada a soma dos valores por chave. 

<code>counts.saveAsTextFile("hdfs://...")</code> - O resultado é armazenado no HDFS.

Número de Hosts únicos: 137979

Total de erros 404: 206863

Os 5 urls que mais causaram o código 404:  
hoohoo.ncsa.uiuc.edu 251  
piweba3y.prodigy.com 157  
jbiagioni.npt.nuwc.navy.mil 132   
piweba1y.prodigy.com 114  
www-d4.proxy.aol.com 91  

Quantidade de erros 404 por dia:  
+-----------+-----+  
|time_stamp |count|  
+-----------+-----+  
|01/Aug/1995|242  |  
|01/Jul/1995|314  |  
|02/Jul/1995|289  |  
|03/Aug/1995|301  |  
|03/Jul/1995|473  |  
|04/Aug/1995|345  |  
|04/Jul/1995|355  |  
|05/Aug/1995|230  |  
|05/Jul/1995|491  |  
|06/Aug/1995|370  |  
|06/Jul/1995|630  |  
|07/Aug/1995|527  |  
|07/Jul/1995|564  |  
|08/Aug/1995|377  |  
|08/Jul/1995|299  |  
|09/Aug/1995|278  |  
|09/Jul/1995|341  |  
|10/Aug/1995|313  |  
|10/Jul/1995|390  |  
|11/Aug/1995|260  |  
|11/Jul/1995|469  |  
|12/Aug/1995|195  |  
|12/Jul/1995|459  |  
|13/Aug/1995|215  |  
|13/Jul/1995|524  |  
|14/Aug/1995|286  |  
|14/Jul/1995|408  |  
|15/Aug/1995|323  |  
|15/Jul/1995|252  |  
|16/Aug/1995|258  |  
|16/Jul/1995|256  |  
|17/Aug/1995|269  |  
|17/Jul/1995|403  |  
|18/Aug/1995|248  |  
|18/Jul/1995|463  |  
|19/Aug/1995|206  |  
|19/Jul/1995|636  |  
|20/Aug/1995|312  |  
|20/Jul/1995|427  |  
|21/Aug/1995|305  |  
|21/Jul/1995|332  |  
|22/Aug/1995|287  |  
|22/Jul/1995|180  |  
|23/Aug/1995|340  |  
|23/Jul/1995|230  |  
|24/Aug/1995|420  |  
|24/Jul/1995|324  |  
|25/Aug/1995|411  |  
|25/Jul/1995|458  |  
|26/Aug/1995|365  |  
|26/Jul/1995|319  |  
|27/Aug/1995|370  |  
|27/Jul/1995|334  |  
|28/Aug/1995|408  |  
|28/Jul/1995|93   |  
|29/Aug/1995|420  |  
|30/Aug/1995|567  |  
|31/Aug/1995|525  |  
+-----------+-----+    

Total de bytes retornados: 3456889

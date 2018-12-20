<h1><center>Desafio de Engenheiro de Dados</h1></center>

O presente projeto contém o script para a performace de ETL nas bases encaminhadas.

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
- Resilient Distributed Dataset também conhecido como RDD é uma abstração de dados principal da ferramenta Apache Spark, poderíamos por exemplo comparar um RDD com uma coleção em Scala.

5 - GroupByKey é menos eficiente que reduceByKey em grandes dataset. Por quê?
- Ao contrário de groupByKey, reduceByKey não mistura os dados no início de sua execução. 

6 - Explique o que o código Scala abaixo faz.

<code>val textFile = sc.textFile("hdfs://...")
val counts = textFile.flatMap(line => line.split(" "))
.map(word => (word, 1))
.reduceByKey(_ + _)
counts.saveAsTextFile("hdfs://...")
</code>



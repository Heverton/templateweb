# templateweb

Java EE 7 WebApplication - Spring 4.x + Spring Security 4.x + JPA 2.1.x + HikariCP 2.x + Boostrap 3

Configurações iniciais:

PASSO1:
CAMINHO::: src/main/resources/
OBJETIVO::: Configuração dos caminhos de LOG, Regionalização e mensagens de retorno de negocio PT/US;

PASSO2:
CAMINHO::: src/main/resources/i18n
OBJETIVO::: Configuração dos nomes de campos padrão;

PASSO3:
CAMINHO::: src/main/resources/spring/mvc-applicationContext.xml
OBJETIVO::: Configuração dos nomes de campos padrão;

<context:component-scan base-package="br.com.????.spring.controller"/>

PASSO4:
CAMINHO::: src/main/resources/spring/persistence-applicationContext.xml
OBJETIVO::: 

<context:component-scan base-package="br.com.???.spring.dao"/>

<props>
	<prop key="url">jdbc:???</prop>
	<prop key="user">???</prop>
	<prop key="password">???</prop>
</props>

PASSO5:
CAMINHO::: src/main/resources/spring/root-applicationContext.xml
OBJETIVO::: 

<context:component-scan base-package="br.com.???.spring"/>

PRONTO.




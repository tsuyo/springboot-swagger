swagger_codegen_jar=./swagger-codegen-cli.jar
spec_file=./swagger.json
group_id=com.github.tsuyo
artifact_id=springboot-swagger-client-swagger
version=0.0.1-SNAPSHOT
package=hello.swagger
dir=springboot-swagger-client-swagger

rm -fr ${dir}
java -jar ${swagger_codegen_jar} generate \
  -i ${spec_file} \
  --api-package ${package}.api \
  --model-package ${package}.model \
  --invoker-package ${package}.invoker \
  --group-id ${group_id} \
  --artifact-id ${artifact_id} \
  --artifact-version ${version} \
  -l java \
  --library resttemplate \
  -D dateLibrary=java8 \
  -o ${dir}

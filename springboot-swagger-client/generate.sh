group_id=com.github.tsuyo
artifact_id=springboot-swagger-client-swagger
version=0.0.1-SNAPSHOT
package=hello.swagger
dir=springboot-swagger-client-swagger

rm -fr ${dir}
java -jar swagger-codegen-cli.jar generate \
  -i ./swagger.json \
  --api-package ${package}.api \
  --model-package ${package}.model \
  --invoker-package ${package}.invoker \
  --group-id ${group_id} \
  --artifact-id ${artifact_id} \
  --artifact-version ${version} \
  -l java \
  --library resttemplate \
  -o ${dir}

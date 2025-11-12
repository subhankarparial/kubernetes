# kubernetes
DOCKER - KUBERNETES
pull image ⇒ docker pull openjdk:26-jdk
run image continuously ⇒ docker run -it openjdk:26-jdk
check running containers ⇒ docker ps
Folders inside containers ⇒ docker exec b363d2ad854e ls -a
Open specific container’s folder ⇒ docker exec b363d2ad854e ls /tmp
Copy hello-world.jar to temp folder of the container ⇒docker cp C:\LEARNING\DOCKER\hello-world\hello-world\target\hello-world.jar b363d2ad854e:/tmp
Create a custom image with the help of existing jdk container and jar ⇒ docker commit b363d2ad854e sp/hello-world
Create a custom image with the help of existing jdk container and jar and changing the default command ⇒  docker commit --change='CMD java -jar /tmp/hello-world.jar' happy_blackburn sp/hello-world:v1
Creating a dockerfile ⇒ on main project create a file with file name Dockerfile
Which contains:
FROM openjdk:26-jdk
ADD /hello-world/target/hello-world.jar hello-world.jar
ENTRYPOINT ["java", "-jar", "/hello-world.jar"]
Docked build ⇒ docker build -t sp/hello-world:v3 .
End dot(.) is to mention current directory
Run the image ⇒ docker run -p 8080:8080 sp/hello-world:v3
Docker Compose
Create jar ⇒ mvn clean package
Build the docker-compose container ⇒docker-compose up --build
Stop the docker-compose container ⇒docker-compose down
Stop the docker-compose container along with data deletion⇒docker-compose down -v

Kubernetes:
Download kubectl.exe & minikube.exe
Add the below path in windows path
C:\LEARNING\DOCKER-KUBERNETES\Softwares
Start Docker→minikube start→minikube status→kubectl cluster-info→kubectl get node
Add docket image repository to kubernetes 
minikube docket-env→@FOR /f "tokens=*" %i IN ('minikube -p minikube docker-env --shell cmd') DO @%i
See docker images
docker images
Build project
C:\LEARNING\DOCKER-KUBERNETES\hello-world>docker build -t hello-world:1.0 .
Check image through ⇒ docker images
Create a deployment based on the provided image
C:\LEARNING\DOCKER-KUBERNETES\hello-world>kubectl create deployment hello-world --image=hello-world:1.0 --port=8080
Describe the deployment
C:\LEARNING\DOCKER-KUBERNETES\hello-world>kubectl get deployment
Get pods
C:\LEARNING\DOCKER-KUBERNETES\hello-world>kubectl get pods
Get the log of a pod
kubectl logs hello-world-6d88f7c9fc-dtlfg
Expose deployment to create a service object
C:\LEARNING\DOCKER-KUBERNETES\hello-world>kubectl expose deployment hello-world --type=NodePort
Get the service url
C:\LEARNING\DOCKER-KUBERNETES\hello-world>minikube service hello-world --url
http://127.0.0.1:56638
Get dashboard url ⇒ C:\LEARNING\DOCKER-KUBERNETES\hello-world>minikube dashboard
Delete service ⇒ kubectl delete service hello-world
Delete deployment ⇒ kubectl delete deployment hello-world
Verify 
C:\LEARNING\DOCKER-KUBERNETES\hello-world>kubectl get deployments
No resources found in default namespace.
C:\LEARNING\DOCKER-KUBERNETES\hello-world>kubectl get service

Through yaml file:
Allow kubernetes to read docker repository:
minikube docket-env→ & minikube -p minikube docker-env --shell powershell | Invoke-Expression
Create the docker image
docker build -t hello-world:1.0 .
create a deployment yaml file in IDE
Create the deployment object with the help of deployment file
kubectl apply -f deployment-dev.yaml
Check deployment & pod
kubectl get deployments→kubectl get pods
Service - plays the role of service discovery & load balancer
create service-dev.yaml in ide
Create the service object with the help of service file - expose to outside cluster
 kubectl apply -f service-dev.yaml→kubectl get services→kubectl get nodes -o wide→ minikube ip
Open working URL
minikube service hello-world-service
=================================
DB
create db-deployment.yaml
kubectl apply -f db-deployment.yaml
kubectl get deployments
kubectl get pods
kubectl logs <pod-name>
login into mysql pod→kubectl exec -it mysql-59b7d998d8-jc478 -- /bin/bash
bash-5.1# mysql mysql -u root -p
Enter password:
show databased;
mysql> use order_directory;

mvn clean package -DskipTests
docker build -t order:1.0 .
kubectl apply -f app-deployment-dev.yaml
kubectl logs <pod_name>
minikube service <service_name>

Final Steps::
minikube start
minikube docker-env
last line of point 2 result
minikube status
mvn clean package -DskipTests
C:\LEARNING\DOCKER-KUBERNETES\order>docker build -t order:1.0 .
kubectl apply -f db-configmap.yaml
kubectl get configmap
kubectl apply -f db-secrets.yaml
kubectl get secrets
kubectl apply -f db-deployment-dev.yaml
kubectl apply -f app-deployment-dev.yaml
C:\Users\Admin>kubectl exec -it mysql-65bc6f4b8c-jj4x2 -- bin/bash
bash-5.1# mysql mysql -u root -p
Enter password:
show databases;
use order_db;
CREATE TABLE orders (id INT NOT NULL AUTO_INCREMENT, product VARCHAR(255) NOT NULL, quantity INT NOT NULL, price DECIMAL(10,2) NOT NULL, PRIMARY KEY (id));
minikube service <service-name>
http://127.0.0.1:63116/orders
minikube dashboard

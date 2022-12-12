# MoviesApp

Es una aplicación en la cual podrás encontrar peliculas y el detalle de ellas.

## Release v1
Pueden encontrar la version 1 del apk [aqui](https://github.com/maryamliza/MoviesApp/releases/tag/v1):

<img width="597" alt="image" src="https://user-images.githubusercontent.com/71225795/207185031-7cd26c0d-531d-4490-9485-0d98db7ea1d3.png">


## Lenguaje:
- Kotlin

## Arquitectura:
- MVVM

## Tecnologías usadas:
- ViewModel
- Coroutines
- Navigation Component
- ViewBinding
- Retrofit
- Koin
- Glide
- Maps SDK
- Mockk

## Pantallas:
<img width="800" alt="image" src="https://user-images.githubusercontent.com/71225795/207184581-fcfac406-9c88-4da8-8491-c96298fe305b.png">


## Funcionalidades claves:

### Filtro de busqueda
Busqueda por nombre, director(es) o actor(es)

<img width="600" alt="image" src="https://user-images.githubusercontent.com/71225795/207183442-0759c243-872c-445b-b057-60cfb9a697bc.png">

### Google Maps
<img width="600" alt="image" src="https://user-images.githubusercontent.com/71225795/207182025-561d0855-e905-4655-8d0e-39bcfd1b89ee.png">

### Soportar Light/Dark Theme
<img width="600" alt="image" src="https://user-images.githubusercontent.com/71225795/207182705-3808c174-a3e8-4d31-a624-2dba25143c7e.png">

### Swipe to Refresh
<img width="600" alt="image" src="https://user-images.githubusercontent.com/71225795/207183175-9953215a-c4de-436d-9734-e87f95cd19e6.png">


### Otros
- UI Intuitivo
- Soporta Ingles/Espanol
- NavigationComponent transitions
- Unit Testing


## API
Se trabajo con APIs mockeadas usando [Apiary](https://apiary.io/)

##### Listar todas las peliculas:
Se tuvo que incluir los actores y directores ya que el filtrado es local (en el app) porque no pude mockear un endpoint que los filtre
<img width="800" alt="MoviesChallenge" src="https://user-images.githubusercontent.com/71225795/207183929-92c57565-4b0a-4081-993b-1848232ac940.png">

##### Detalles de pelicula:
Trae toda la informacion de una pelicula especifica
<img width="800" alt="MoviesChallenge" src="https://user-images.githubusercontent.com/71225795/207183940-8499f50f-ebeb-4355-8c37-95c98882e794.png">



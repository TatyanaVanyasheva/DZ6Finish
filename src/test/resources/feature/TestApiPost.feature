#language:ru

@TEST1
Функция: Обменн данными с сервером по ip
  Сценарий: Считываем данные из файла, вносим изменения, отправляем на серер и проверяем получанные данные
    Когда Считываем данные из файла
    Тогда Изменяем данные в json-объекте
    Затем Оправляем строку запроса на сервер и проверяем данные

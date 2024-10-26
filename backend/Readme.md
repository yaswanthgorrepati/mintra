### 1. Image upload[October 16th]
Upload API
``` JSON
curl --location 'localhost:8080/image' \
--form 'multipartFile=@"/Users/yaswanth/Downloads/Nature.jpg"'
``` 


response:

``` JSON
{
  "asset_folder": "",
  "signature": "f1510a286bcc705303bbff424b3a2c304ca90336",
  "format": "jpg",
  "resource_type": "image",
  "secure_url": "https://res.cloudinary.com/df2plpdhf/image/upload/v1729087550/Nature.jpg",
  "created_at": "2024-10-16T14:05:50Z",
  "asset_id": "87d31f98b7f5ab9f60e77b36ec7c5f88",
  "version_id": "da416f848a6929c8e4cdea3be5023d83",
  "type": "upload",
  "display_name": "Nature",
  "version": 1729087550,
  "url": "http://res.cloudinary.com/df2plpdhf/image/upload/v1729087550/Nature.jpg",
  "public_id": "Nature",
  "tags": [],
  "original_filename": "Nature",
  "api_key": "878644428765874",
  "bytes": 11103,
  "overwritten": true,
  "width": 275,
  "etag": "495367d3d795d1f04deae058c208176a",
  "placeholder": false,
  "height": 183
}
``` 

### 1.1 Fetch API
``` JSON
curl --location 'localhost:8080/image?name=Nature'
``` 

Response:
``` JSON
{
  "asset_folder": "",
  "next_cursor": "8aba18bbad2db72cda17f0c7ebdd5d54771b79f21f6492c3b4bbd4c0ae01ebf3",
  "usage": {},
  "format": "jpg",
  "resource_type": "image",
  "secure_url": "https://res.cloudinary.com/df2plpdhf/image/upload/v1729087550/Nature.jpg",
  "created_at": "2024-10-16T14:05:50Z",
  "asset_id": "87d31f98b7f5ab9f60e77b36ec7c5f88",
  "type": "upload",
  "display_name": "Nature",
  "version": 1729087550,
  "url": "http://res.cloudinary.com/df2plpdhf/image/upload/v1729087550/Nature.jpg",
  "public_id": "Nature",
  "pages": 1,
  "original_filename": "Nature",
  "bytes": 11103,
  "width": 275,
  "quality_analysis": {
    "focus": 1
  },
  "etag": "495367d3d795d1f04deae058c208176a",
  "derived": [],
  "height": 183
}
```
### 2. Product save API[October 25th]

Product save API

Request:
``` JSON
curl --location --globoff 'localhost:8080/product/v2/{cat}' \
--form 'productJson="{ \"brandName\": \"testbn\", \"description\": \"testdesc\", \"price\": { \"actualPrice\": 100, \"discount\": 10 }, \"productSpecification\": { \"fitType\": \"regular_fit\", \"fabric\": \"cotton\", \"numberOfPockets\": 4 }, \"rating\": { \"stars\": 4.5, \"totalRatings\": 100 }, \"reviewList\": [ { \"userName\": \"test_1\", \"description\": \"very good\" }, { \"userName\": \"test_2\", \"description\": \"super good\" } ], \"sizeList\": [ { \"size\": \"32\" }, { \"size\": \"L\" } ] }";type=application/json' \
--form 'images=@"/Users/yaswanth/Downloads/img1.jpeg"' \
--form 'images=@"/Users/yaswanth/Downloads/Img2.jpeg"' \
--form 'images=@"/Users/yaswanth/Downloads/Img3.jpeg"'
``` 
Response:
``` JSON
{
  "productId": 1,
  "brandName": "testbn",
  "description": "testdesc",
  "price": {
    "finalPrice": 0,
    "actualPrice": 100,
    "discount": 10
  },
  "rating": {
    "stars": 4.5,
    "totalRatings": 100
  },
  "picture": {
    "imageUrl_1": "http://res.cloudinary.com/df2plpdhf/image/upload/v1729329224/img1.jpg",
    "imageUrl_2": "http://res.cloudinary.com/df2plpdhf/image/upload/v1729329436/Img2.jpg",
    "imageUrl_3": "http://res.cloudinary.com/df2plpdhf/image/upload/v1729329437/Img3.jpg"
  },
  "sizeList": [
    {
      "size": "32"
    },
    {
      "size": "L"
    }
  ],
  "productSpecification": {
    "fitType": "regular_fit",
    "fabric": "cotton",
    "numberOfPockets": 4
  },
  "reviewList": [
    {
      "userName": "test_1",
      "description": "very good"
    },
    {
      "userName": "test_2",
      "description": "super good"
    }
  ]
}
``` 
### 3. Product fetch API

Request:
``` JSON
curl --location 'localhost:8080/product/cat/1'
``` 
Response:
``` JSON
{
  "productId": 1,
  "brandName": "testbn",
  "description": "testdesc",
  "price": {
    "finalPrice": 90,
    "actualPrice": 100,
    "discount": 10
  },
  "rating": {
    "stars": 4.5,
    "totalRatings": 100
  },
  "picture": {
    "imageUrl_1": "http://res.cloudinary.com/df2plpdhf/image/upload/v1729329224/img1.jpg",
    "imageUrl_2": "http://res.cloudinary.com/df2plpdhf/image/upload/v1729329436/Img2.jpg",
    "imageUrl_3": "http://res.cloudinary.com/df2plpdhf/image/upload/v1729329437/Img3.jpg"
  },
  "sizeList": [
    {
      "size": "32"
    },
    {
      "size": "L"
    }
  ],
  "productSpecification": {
    "fitType": "regular_fit",
    "fabric": "cotton",
    "numberOfPockets": 4
  },
  "reviewList": [
    {
      "userName": "test_1",
      "description": "very good"
    },
    {
      "userName": "test_2",
      "description": "super good"
    }
  ]
}
```


### 4.PostReview API[October 26th]

``` JSON
curl --location 'localhost:8080/review/2' \
--header 'Content-Type: application/json' \
--data '{
"userName": "test_1",
"description": "very cvb good",
"stars": 1
}'
``` 

Response:

``` JSON
{
    "productId": 2,
    "userName": "test_1",
    "description": "very cvb good",
    "stars": 1.0
}
```

### 5.Delete Review API

Request:
``` JSON
curl --location --request DELETE 'localhost:8080/review/1' \
--header 'Content-Type: application/json' \
--data '{
"userName": "test_1"
}'
```
Response:
``` JSON
{
  "message": "1 Review deleted successfully"
}
```

### 6. Get Review API for a user and product

Request:

``` JSON
curl --location --request GET 'localhost:8080/review/1' \
--header 'Content-Type: application/json' \
--data '{
"userName": "test_1"
}'
```
Response:
``` JSON
{
  "productId": 1,
  "userName": "test_1",
  "description": "very good",
  "stars": 5
}
```

### 7. Get Review for a User API

Request:
``` JSON
curl --location --request GET 'localhost:8080/review' \
--header 'Content-Type: application/json' \
--data '{
"userName": "test_1"
}'
```
Response:
``` JSON
[
  {
    "productId": 2,
    "userName": "test_1",
    "description": "very cvb good",
    "stars": 1
  },
  {
    "productId": 3,
    "userName": "test_1",
    "description": "very good",
    "stars": 5
  }
]
```

### 8.CART Get API

Request:
``` JSON
curl --location --request GET 'localhost:8080/cart' \
--header 'Content-Type: application/json' \
--data '{
    "userName":"test"
}'
```

Response:
``` JSON
{
    "cartProductResponseJsonList": [
        {
            "productJson": {
                "productId": 1,
                "brandName": "testbn",
                "description": "testdesc",
                "price": {
                    "finalPrice": 90.0,
                    "actualPrice": 100.0,
                    "discount": 10.0
                },
                "rating": {
                    "stars": 3.0,
                    "totalRatings": 2
                },
                "picture": {
                    "imageUrl_1": "http://res.cloudinary.com/df2plpdhf/image/upload/v1729329224/img1.jpg",
                    "imageUrl_2": "http://res.cloudinary.com/df2plpdhf/image/upload/v1729329436/Img2.jpg",
                    "imageUrl_3": "http://res.cloudinary.com/df2plpdhf/image/upload/v1729329437/Img3.jpg"
                },
                "sizeList": [
                    {
                        "size": "32"
                    },
                    {
                        "size": "L"
                    }
                ],
                "productSpecification": {
                    "fitType": "regular_fit",
                    "fabric": "cotton",
                    "numberOfPockets": 4
                },
                "reviewList": [
                    {
                        "userName": "test_1",
                        "description": "very good",
                        "stars": 5.0
                    },
                    {
                        "userName": "test_2",
                        "description": "super good",
                        "stars": 1.0
                    }
                ]
            },
            "quantity": 2,
            "price": 180.0
        },
        {
            "productJson": {
                "productId": 2,
                "brandName": "testbn",
                "description": "testdesc",
                "price": {
                    "finalPrice": 90.0,
                    "actualPrice": 100.0,
                    "discount": 10.0
                },
                "rating": {
                    "stars": 3.0,
                    "totalRatings": 2
                },
                "picture": {
                    "imageUrl_1": "http://res.cloudinary.com/df2plpdhf/image/upload/v1729329224/img1.jpg",
                    "imageUrl_2": "http://res.cloudinary.com/df2plpdhf/image/upload/v1729329436/Img2.jpg",
                    "imageUrl_3": "http://res.cloudinary.com/df2plpdhf/image/upload/v1729329437/Img3.jpg"
                },
                "sizeList": [
                    {
                        "size": "32"
                    },
                    {
                        "size": "L"
                    }
                ],
                "productSpecification": {
                    "fitType": "regular_fit",
                    "fabric": "cotton",
                    "numberOfPockets": 4
                },
                "reviewList": [
                    {
                        "userName": "test_1",
                        "description": "very good",
                        "stars": 5.0
                    },
                    {
                        "userName": "test_2",
                        "description": "super good",
                        "stars": 1.0
                    }
                ]
            },
            "quantity": 5,
            "price": 450.0
        }
    ],
    "cartValue": 630.0
}
```
### 9.CART POST API

Request:
``` JSON
curl --location 'localhost:8080/cart' \
--header 'Content-Type: application/json' \
--data '{
    "userName":"test",
    "productId":2,
    "quantity": 5
}'
```

Response:
``` JSON
{
    "productJson": {
        "productId": 2,
        "brandName": "testbn",
        "description": "testdesc",
        "price": {
            "finalPrice": 90.0,
            "actualPrice": 100.0,
            "discount": 10.0
        },
        "rating": {
            "stars": 3.0,
            "totalRatings": 2
        },
        "picture": {
            "imageUrl_1": "http://res.cloudinary.com/df2plpdhf/image/upload/v1729329224/img1.jpg",
            "imageUrl_2": "http://res.cloudinary.com/df2plpdhf/image/upload/v1729329436/Img2.jpg",
            "imageUrl_3": "http://res.cloudinary.com/df2plpdhf/image/upload/v1729329437/Img3.jpg"
        },
        "sizeList": [
            {
                "size": "32"
            },
            {
                "size": "L"
            }
        ],
        "productSpecification": {
            "fitType": "regular_fit",
            "fabric": "cotton",
            "numberOfPockets": 4
        },
        "reviewList": [
            {
                "userName": "test_1",
                "description": "very good",
                "stars": 5.0
            },
            {
                "userName": "test_2",
                "description": "super good",
                "stars": 1.0
            }
        ]
    },
    "quantity": 5,
    "price": 450.0
}
```

### 10.CART Delete API

Request:
``` JSON
curl --location --request DELETE 'localhost:8080/cart' \
--header 'Content-Type: application/json' \
--data '{
    "userName":"test",
    "productId":2
}'
```

Response:
``` JSON
{
    "message": "1 Product deleted successfully"
}
```

### 11. Register New User

Request:
``` JSON
curl --location 'localhost:8080/user' \
--header 'Content-Type: application/json' \
--data '{
    "userName":"test",
    "password":"123"
}'
```

Response:
``` JSON
{
    "userId": 1,
    "userName": "test",
    "message": "User registered successfully"
}
```

### 12. User Validation

Request:
``` JSON
curl --location --request GET 'localhost:8080/user' \
--header 'Content-Type: application/json' \
--data '{
    "userName":"test",
    "password":"123"
}'
```

Response:
``` JSON
{
    "message": "User is valid"
}
```

### 13.

Request:
``` JSON

```

Response:
``` JSON

```
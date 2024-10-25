### 1. Image upload[October 16th]
Upload API
curl --location 'localhost:8080/image' \
--form 'multipartFile=@"/Users/yaswanth/Downloads/Nature.jpg"'

response:



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

Fetch API
curl --location 'localhost:8080/image?name=Nature'

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
"focus": 1.0
},
"etag": "495367d3d795d1f04deae058c208176a",
"derived": [],
"height": 183
}

### 2. Product save API[October 25th]

Product save API

Request:
curl --location --globoff 'localhost:8080/product/v2/{cat}' \
--form 'productJson="{ \"brandName\": \"testbn\", \"description\": \"testdesc\", \"price\": { \"actualPrice\": 100, \"discount\": 10 }, \"productSpecification\": { \"fitType\": \"regular_fit\", \"fabric\": \"cotton\", \"numberOfPockets\": 4 }, \"rating\": { \"stars\": 4.5, \"totalRatings\": 100 }, \"reviewList\": [ { \"userName\": \"test_1\", \"description\": \"very good\" }, { \"userName\": \"test_2\", \"description\": \"super good\" } ], \"sizeList\": [ { \"size\": \"32\" }, { \"size\": \"L\" } ] }";type=application/json' \
--form 'images=@"/Users/yaswanth/Downloads/img1.jpeg"' \
--form 'images=@"/Users/yaswanth/Downloads/Img2.jpeg"' \
--form 'images=@"/Users/yaswanth/Downloads/Img3.jpeg"'

Response:

{
"productId": 1,
"brandName": "testbn",
"description": "testdesc",
"price": {
"finalPrice": 0.0,
"actualPrice": 100.0,
"discount": 10.0
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

### 3. Product fetch API

Request:
curl --location 'localhost:8080/product/cat/1'
Response:
{
"productId": 1,
"brandName": "testbn",
"description": "testdesc",
"price": {
"finalPrice": 90.0,
"actualPrice": 100.0,
"discount": 10.0
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

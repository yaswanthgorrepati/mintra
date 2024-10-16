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
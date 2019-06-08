const client = filestack.init(filestackToken)
const options = {
    onUploadDone: updateForm(),
    maxSize: window.location,
    accept: 'image/*',
    uploadInBackground: false
};

const picker = client.picker(options);

;

